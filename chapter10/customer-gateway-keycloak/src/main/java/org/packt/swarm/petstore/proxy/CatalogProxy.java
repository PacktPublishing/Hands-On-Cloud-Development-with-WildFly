package org.packt.swarm.petstore.proxy;

import org.packt.swarm.petstore.catalog.api.CatalogItem;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class CatalogProxy {

    private String targetPath = System.getProperty("proxy.catalog.url");

    public List<CatalogItem> getAllItems(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(targetPath+"/item");
        return Arrays.asList(target.request(MediaType.APPLICATION_JSON).get(CatalogItem[].class));
    }

    public CatalogItem getItem(String itemId){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(targetPath+"/item/"+itemId);
        return target.request(MediaType.APPLICATION_JSON).get(CatalogItem.class);
    }

}