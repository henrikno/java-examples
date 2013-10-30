package com.example.resource;

import com.example.service.FooModel;
import com.example.service.FooService;
import com.yammer.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/foo")
@Produces("application/json")
public class FooResource {

    @Inject
    FooService fooService;

    @GET
    @Timed
    public FooModel getFoo() {
        return fooService.findFoo();
    }
}
