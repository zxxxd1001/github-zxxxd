package git.zxxxd.api;


import git.zxxxd.facade.TestFacade;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestResource {

    @Inject
    private TestFacade testFacade;

    @GET
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {
        String test = testFacade.test();
        System.out.println(test);
        return Response.ok().entity(test).build();
    }
    @GET
    @Path("hello-word")
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloWord() {
        return Response.ok().entity("hello-word").build();
    }
}
