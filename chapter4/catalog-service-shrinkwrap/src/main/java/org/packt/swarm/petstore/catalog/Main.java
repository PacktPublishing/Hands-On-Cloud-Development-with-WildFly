package org.packt.swarm.petstore.catalog;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.packt.swarm.petstore.catalog.model.Item;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Main {

    public static void main(String[] args) throws Exception {

        Swarm swarm = new Swarm();
        swarm.start();

        //1
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class, "deployment.war");
        //2
        deployment.addClasses(CatalogApplication.class, CatalogResource.class, Item.class);
        swarm.deploy(deployment);
    }
}
