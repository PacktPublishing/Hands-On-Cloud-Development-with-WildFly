package org.packt.swarm.petstore.pricing;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.packt.swarm.petstore.pricing.model.Price;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;

import javax.inject.Inject;
import java.net.URL;

//1
@RunWith(Arquillian.class)
public class PricingServiceTest {

    //2
    @Deployment
    public static Archive<WebArchive> createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addClasses(Price.class, PricingService.class)
                .addAsResource("test-datasource.yml")
                .addAsResource("META-INF/persistence.xml")
                .addAsResource("META-INF/load.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        return archive;
    }

    //2
    @CreateSwarm
    public static Swarm createSwarm() throws Exception {
        Swarm swarm = new Swarm();
        //3
        ClassLoader cl = PricingServiceTest.class.getClassLoader();
        URL dataSourcesConfig = cl.getResource("test-datasource.yml");
        swarm.withConfig(dataSourcesConfig);
        return swarm;
    }

    //3
    @Inject
    PricingService pricingService;

    //4
    @Test
    public void testSearchById() {
        Assert.assertEquals(pricingService.findByItemId("test-pet").getPrice(),5);
    }
}
