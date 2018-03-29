package org.packt.swarm.petstore.catalog;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.packt.swarm.petstore.catalog.model.Item;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.net.URL;

@RunWith(Arquillian.class)
public class CatalogServiceTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                //1
                .addClasses(Item.class, CatalogService.class, CatalogResource.class, CatalogApplication.class)
                .addAsResource("datasources.yml")
                .addAsResource("META-INF/persistence.xml")
                .addAsResource("META-INF/load.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @CreateSwarm
    public static Swarm createSwarm() throws Exception {
        Swarm swarm = new Swarm();
        ClassLoader cl = CatalogServiceTest.class.getClassLoader();
        URL dataSourcesConfig = cl.getResource("datasources.yml");
        swarm.withConfig(dataSourcesConfig);
        return swarm;
    }

    //2
    private static Client client;

    //3
    @BeforeClass
    public static void setUpClient() {
        client = ClientBuilder.newClient();
    }

    //4
    @ArquillianResource
    private URL url;

    //5
    private Item testEndpoint(String itemId) {
        WebTarget target = client.target(url + "item/"+itemId);
        return target.request("application/json").get(Item.class);
    }

    @Test
    //6
    @RunAsClient
    public void testSearchById() {
        //7
        Assert.assertEquals(testEndpoint("turtle").getName(),"turtle");
        Assert.assertEquals(testEndpoint("hamster").getName(),"hamster");
    }
}