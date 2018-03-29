package org.packt.swarm.petstore.catalog;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import javax.inject.Inject;

@RunWith(Arquillian.class)
@DefaultDeployment
public class CatalogServiceTest {


    @Inject
    CatalogService catalogService;

    @Test
    public void testSearchById() {
        Assert.assertEquals(catalogService.searchById("turtle").getName(),"turtle");
    }
}