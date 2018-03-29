package org.packt.swarm.petstore.cart;

import org.packt.swarm.petstore.cart.api.Item;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/")
public class CartResource {

    @Inject
    private CartService cartService;

    @GET
    @Path("cart/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCart(@PathParam("customerId") String customerId) {
        System.out.println("IDZIE GET CART");
        Collection<Item> cart = cartService.getCart(customerId);
        System.out.println("ZWRADCAM CARTA "+cart);
        return Response.ok(cart).build();
    }

    @POST
    @Path("cart/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addItem(@PathParam("customerId") String customerId, Item item, @QueryParam("additive") boolean additive) {
        System.out.println("IDZIE ADD TO CART");
        cartService.addItem(customerId, item, additive);
        return Response.ok().build();
    }

    @DELETE
    @Path("cart/{customerId}/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteItem(@PathParam("customerId") String customerId, @PathParam("itemId") String itemId) {
        cartService.deleteItem(customerId, itemId);
        return Response.ok().build();
    }

}
