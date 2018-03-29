package org.packt.swarm.petstore;

import org.jboss.shrinkwrap.api.Archive;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.keycloak.Secured;

import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();

        ClassLoader cl = Main.class.getClassLoader();
        URL ymlConfig = cl.getResource("proxies.yml");

        swarm.withConfig(ymlConfig);
        swarm.start();

        Archive<?> deployment = swarm.createDefaultDeployment();
        secureDeployment(deployment);

        swarm.deploy(deployment);
    }

    private static void secureDeployment(final Archive<?> deployment){
        deployment.as(Secured.class)
                .protect("/cart/*")
                .withMethod("POST","GET","DELETE")
                .withRole("customer");
    }
}