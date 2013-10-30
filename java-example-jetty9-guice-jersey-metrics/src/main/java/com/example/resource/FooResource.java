package com.example.resource;

import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/foo")
@Produces("application/json")
public class FooResource {
    @GET
    @Timed
    public String getFoo() {
        return "Foo";
    }
}
