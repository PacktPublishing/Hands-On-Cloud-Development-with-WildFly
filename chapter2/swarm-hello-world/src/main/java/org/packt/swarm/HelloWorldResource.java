package org.packt.swarm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//1
@Path("/")
public class HelloWorldResource {

    //2
    @GET
    //3
    @Path("hello")
    @Produces({ "text/plain" })
    public String hello() {
        return "Hello World!";
    }
}
