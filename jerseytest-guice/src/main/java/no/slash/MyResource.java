package no.slash;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class MyResource {

    @Inject
    private MyService service;

    @GET
    public String test() {
        System.out.println("Hey!");
        return service.getValue();
    }

}
