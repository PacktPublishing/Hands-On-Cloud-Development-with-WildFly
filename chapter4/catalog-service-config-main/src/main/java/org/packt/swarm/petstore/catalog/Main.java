package org.packt.swarm.petstore.catalog;

import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.undertow.UndertowFraction;

public class Main {

    public static void main(String[] args) throws Exception {
        //1
        UndertowFraction undertowFraction = new UndertowFraction();
        //2
        undertowFraction.applyDefaults();
        //3
        undertowFraction.httpPort(12345);
        //4
        Swarm swarm = new Swarm();
        //5
        swarm.fraction(undertowFraction);
        //6
        swarm.start().deploy();
    }
}
