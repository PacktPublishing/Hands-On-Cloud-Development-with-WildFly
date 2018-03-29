package org.packt.swarm.petstore.proxy;

import org.packt.swarm.petstore.pricing.api.Price;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class PricingProxy {

    private String targetPath;

    PricingProxy(){
        //1
        targetPath = "http://" + System.getenv("PRICING_SERVICE_SERVICE_HOST")+":"+8080;
    }

    public Price getPrice(String name){
        //2
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target( targetPath +"/price/" + name);
        return target.request(MediaType.APPLICATION_JSON).get(Price.class);
    }
}
