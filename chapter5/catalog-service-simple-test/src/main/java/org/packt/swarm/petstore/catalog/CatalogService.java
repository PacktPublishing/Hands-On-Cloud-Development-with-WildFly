package org.packt.swarm.petstore.catalog;

import org.packt.swarm.petstore.catalog.model.Item;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CatalogService {

    private Map<String, Item> catalog = new HashMap<>();

    public CatalogService(){
        Item turtle = new Item();
        turtle.setItemId("turtle");
        turtle.setName("turtle");
        turtle.setQuantity(5);
        turtle.setDescription("Slow, friendly reptile. Let your busy self see how it spends 100 years of his life laying on sand and swimming.");
        catalog.put("turtle", turtle);
    }

    public Item searchById(String itemId){
        return catalog.get(itemId);
    }

}
