package org.packt.swarm.petstore.catalog;

import org.jboss.logging.Logger;
import org.wildfly.swarm.Swarm;

public class Main {

    public static void main(String[] args) throws Exception {
        //1
        new Swarm().start().deploy();
        //2
        Logger.getLogger(Main.class).info("I'M HERE!");
    }
}
