package org.packt.swarm.petstore;

import org.packt.swarm.petstore.api.CartItemView;
import org.packt.swarm.petstore.api.CatalogItemView;
import org.packt.swarm.petstore.cart.api.CartItem;

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
import java.util.List;

@Path("/")
public class GatewayResource {

    @Inject
    private GatewayService gatewayService;

    @GET
    @Path("/catalog/item")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems() {
        List<CatalogItemView> result = gatewayService.getItems();
        return Response.ok(result).build();
    }

    @GET
    @Path("/cart/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCart(@PathParam("customerId") String customerId) {
        List<CartItemView> cart = gatewayService.getCart(customerId);
        return Response.ok(cart).build();
    }

    @POST
    @Path("/cart/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addToCart(@PathParam("customerId") String customerId, CartItem item, @QueryParam("additive") boolean additive) {
        gatewayService.addToCart(customerId, item, additive);
        return Response.ok().build();
    }

    @DELETE
    @Path("/cart/{customerId}/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFromCart(@PathParam("customerId") String customerId, @PathParam("itemId") String itemId) {
        gatewayService.deleteFromCart(customerId, itemId);
        return Response.ok().build();
    }

}
