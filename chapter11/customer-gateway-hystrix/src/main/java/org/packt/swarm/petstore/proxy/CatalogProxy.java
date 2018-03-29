package org.packt.swarm.petstore.proxy;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import org.packt.swarm.petstore.catalog.api.CatalogItem;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class CatalogProxy {

    private String targetPath = System.getProperty("proxy.catalog.url");

    public List<CatalogItem> getAllItems(){
        Response response = new GetItemsCommand().execute();
        return Arrays.asList(response.readEntity(CatalogItem[].class));
    }

    public CatalogItem getItem(String itemId){
        Response response = new GetItemCommand(itemId).execute();
        return response.readEntity(CatalogItem.class);
    }

    private class GetItemsCommand extends HystrixCommand<Response> {


        public GetItemsCommand() {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("catalog-service"))
                    .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(3)));
        }

        @Override
        protected Response run() {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(targetPath+"/item");
            return target.request(MediaType.APPLICATION_JSON).get();
        }
    }

    private class GetItemCommand extends HystrixCommand<Response> {

        private final String itemId;

        public GetItemCommand(String itemId) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("catalog-service"))
                    .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(3)));
            this.itemId = itemId;
        }

        @Override
        protected Response run() {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(targetPath+"/item/"+itemId);
            return target.request(MediaType.APPLICATION_JSON).get();
        }
    }

}