package org.packt.swarm.petstore;

import org.packt.swarm.petstore.api.CatalogItemView;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}
