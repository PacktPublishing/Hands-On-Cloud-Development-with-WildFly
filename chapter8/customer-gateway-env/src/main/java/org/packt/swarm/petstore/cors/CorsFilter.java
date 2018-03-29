package org.packt.swarm.petstore.cors;

import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {
    public void filter(ContainerRequestContext req, ContainerResponseContext res)
            throws IOException {
        res.getHeaders().add("Access-Control-Allow-Origin", "*");
        res.getHeaders().add("Access-Control-Allow-Methods", "GET,POST,DELETE");
        res.getHeaders().add("Access-Control-Allow-Headers","Content-Type,Authorization");
    }
}