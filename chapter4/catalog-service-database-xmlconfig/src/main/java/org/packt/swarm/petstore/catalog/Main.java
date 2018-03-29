package org.packt.swarm.petstore.catalog;

import org.wildfly.swarm.Swarm;

import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm();

        //1
        ClassLoader cl = Main.class.getClassLoader();
        URL xmlConfig = cl.getResource("datasources.xml");

        //2
        swarm.withXmlConfig(xmlConfig);

        swarm.start().deploy();
    }
}