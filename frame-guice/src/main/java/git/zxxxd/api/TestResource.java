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
    public Response test(){
        System.out.println(testFacade.test());
        return Response.ok().entity(testFacade.test()).build();
    }
}
