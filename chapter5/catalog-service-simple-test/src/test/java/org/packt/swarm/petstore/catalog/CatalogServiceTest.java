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

import javax.inject.Inject;

//1
@RunWith(Arquillian.class)
public class CatalogServiceTest {

    //2
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(Item.class,CatalogService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    //3
    @Inject
    CatalogService catalogService;

    //4
    @Test
    public void testSearchById() {
        Assert.assertEquals(catalogService.searchById("turtle").getName(),"turtle");
    }
}