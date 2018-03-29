package org.packt.swarm.petstore.pricing;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.spi.api.Module;

import javax.inject.Inject;

//1
//@RunWith(Arquillian.class)
public class PricingServiceTest {

//    //2
//    @Deployment
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class)
//                .addClasses(Price.class, PricingService.class)
//                .addAsResource("META-INF/persistence.xml")
//                .addAsResource("META-INF/load.sql")
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//    }
//
//    //2
//    @CreateSwarm
//    public static Swarm createSwarm() throws Exception {
//        DatasourcesFraction datasourcesFraction = new DatasourcesFraction()
//                //3
//                .jdbcDriver("h2", (d) -> {
//                    d.driverClassName("org.h2.Driver");
//                    d.xaDatasourceClass("org.h2.jdbcx.JdbcDataSource");
//                    d.driverModuleName("com.h2database.h2");
//                })
//                .dataSource("PricingDS", (ds) -> {
//                    ds.driverName("h2");
//                    ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
//                    ds.userName("sa");
//                    ds.password("sa");
//                });
//
//        Swarm swarm = new Swarm();
//        swarm.fraction(datasourcesFraction);
//
//        return swarm;
//    }
//
//    //3
//    @Inject
//    PricingService pricingService;

    //4
    @Test
    public void testSearchById() {
       try {
           Thread.sleep(15000);
       } catch(Exception e){}
       //Assert.assertTrue(false);
        //Assert.assertEquals(pricingService.findByName("test-pet").getPrice(),5);
    }
}
