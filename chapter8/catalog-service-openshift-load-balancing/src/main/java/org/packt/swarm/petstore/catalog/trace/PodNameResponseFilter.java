package org.packt.swarm.petstore.catalog;

import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

//1
@Provider
public class PodNameResponseFilter implements ContainerResponseFilter {
    public void filter(ContainerRequestContext req, ContainerResponseContext res)
            throws IOException
    {
        //2
        res.getHeaders().add("pod",System.getenv("HOSTNAME"));
    }
}