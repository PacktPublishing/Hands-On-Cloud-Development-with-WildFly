package org.packt.swarm.petstore.cart;

import org.jboss.shrinkwrap.api.Archive;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.keycloak.Secured;

public class Main {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();
        swarm.start();

        Archive<?> deployment = swarm.createDefaultDeployment();
        secureDeployment(deployment);

        swarm.deploy(deployment);
    }

    private static void secureDeployment(final Archive<?> deployment){
        deployment.as(Secured.class)
                .protect( "/cart/*" )
                .withMethod( "POST","GET","DELETE")
                .withRole( "customer" );
    }
}