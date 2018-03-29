package org.packt.swarm.petstore.proxy;

import org.packt.swarm.petstore.pricing.api.Price;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class PricingProxy {

    private final String targetPath = System.getProperty("proxy.pricing.url");

    public Price getPrice(String itemId){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(targetPath + "/price/" + itemId);
        return target.request(MediaType.APPLICATION_JSON).get(Price.class);
    }
}

