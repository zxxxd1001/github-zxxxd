package git.zxxxd.resource;


import git.zxxxd.facade.TestFacade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class Test {

    @Resource
    private TestFacade testFacade;

    @GET
    @Path("/add")
    public void add(){
        System.out.println("12313212");
        testFacade.getTest();
    }
}
