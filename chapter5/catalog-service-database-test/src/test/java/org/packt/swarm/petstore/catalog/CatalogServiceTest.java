package org.packt.swarm.petstore.catalog;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.packt.swarm.petstore.catalog.model.Item;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;

import javax.inject.Inject;
import java.net.URL;

//1
@RunWith(Arquillian.class)
public class CatalogServiceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(Item.class, CatalogService.class)
                //1
                .addAsResource("datasources.yml")
                .addAsResource("META-INF/persistence.xml")
                .addAsResource("META-INF/load.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    //2
    @CreateSwarm
    public static Swarm createSwarm() throws Exception {
        Swarm swarm = new Swarm();
        //3
        ClassLoader cl = CatalogServiceTest.class.getClassLoader();
        URL dataSourcesConfig = cl.getResource("datasources.yml");
        //4
        swarm.withConfig(dataSourcesConfig);
        return swarm;
    }

    //4
    @Inject
    CatalogService catalogService;

    //5
    @Test
    public void testSearchById() {
        Assert.assertEquals(catalogService.searchById("turtle").getName(),"turtle");
    }
}