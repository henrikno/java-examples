package com.example;

import com.yammer.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloWorldController {

    @GET
    @Timed
    public String hello() {
        return "Hello World";
    }
}
