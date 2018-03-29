package org.packt.swarm.petstore.catalog;

import org.wildfly.swarm.Swarm;

import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {
        ClassLoader cl = Main.class.getClassLoader();
        URL dataSourcesConfig = cl.getResource("datasources.yml");

        //2
        Swarm swarm = new Swarm();
        swarm.withConfig(dataSourcesConfig);
        swarm.start().deploy();
    }
}