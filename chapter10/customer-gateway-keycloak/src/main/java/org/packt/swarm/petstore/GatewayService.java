package org.packt.swarm.petstore;

import org.packt.swarm.petstore.api.CartItemView;
import org.packt.swarm.petstore.api.CatalogItemView;
import org.packt.swarm.petstore.cart.api.CartItem;
import org.packt.swarm.petstore.catalog.api.CatalogItem;
import org.packt.swarm.petstore.pricing.api.Price;
import org.packt.swarm.petstore.proxy.CartProxy;
import org.packt.swarm.petstore.proxy.CatalogProxy;
import org.packt.swarm.petstore.proxy.PricingProxy;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GatewayService {

    @Inject
    private CatalogProxy catalogProxy;

    @Inject
    private PricingProxy pricingProxy;

    @Inject
    private CartProxy cartProxy;



    public List<CatalogItemView> getItems() {
        List<CatalogItemView> views = new ArrayList<>();
        for(CatalogItem item: catalogProxy.getAllItems()) {
            Price price = pricingProxy.getPrice(item.getItemId());

            CatalogItemView view = new CatalogItemView();
            view.setItemId(item.getItemId());
            view.setName(item.getName());
            view.setPrice(price.getPrice());
            view.setQuantity(item.getQuantity());
            view.setDescription(item.getDescription());

            views.add(view);
        }
        return views;
    }

    public void addToCart(String customerId, CartItem item, boolean additive){
        cartProxy.addToCart(customerId, item, additive);
    }

    public void deleteFromCart(String customerId, String itemId){
        cartProxy.deleteFromCart(customerId, itemId);
    }

    public List<CartItemView> getCart(String customerId){
        List<CartItemView> results = new ArrayList<>();
        for(CartItem cartItem: cartProxy.getCart(customerId)){
            CartItemView result = new CartItemView();

            result.setItemId(cartItem.getItemId());
            result.setQuantity(cartItem.getQuantity());

            CatalogItem catalogItem = catalogProxy.getItem(cartItem.getItemId());
            result.setName(catalogItem.getName());

            Price price = pricingProxy.getPrice(catalogItem.getItemId());
            result.setPrice(price.getPrice());

            results.add(result);
        }

        return results;

    }

}
