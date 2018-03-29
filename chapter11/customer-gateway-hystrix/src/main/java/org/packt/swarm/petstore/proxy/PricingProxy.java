package org.packt.swarm.petstore.proxy;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import org.packt.swarm.petstore.pricing.api.Price;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class PricingProxy {

    private String targetPath = System.getProperty("proxy.pricing.url");

    public Price getPrice(String itemId){
        Response response = new GetPriceCommand(itemId).execute();
        if(response.getStatus() != Response.Status.OK.getStatusCode()){
            throw new WebApplicationException(response);
        }
        return response.readEntity(Price.class);
    }

    private class GetPriceCommand extends HystrixCommand<Response> {

        private final String itemId;

        public GetPriceCommand(String itemId) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("pricing-service"))
                    .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(3)));
            this.itemId = itemId;
        }

        @Override
        protected Response run() {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(targetPath + "/price/" + itemId);
            return target.request(MediaType.APPLICATION_JSON).get();
        }

        @Override
        //1
        protected Response getFallback() {
            //2
            return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
        }
    }
}

