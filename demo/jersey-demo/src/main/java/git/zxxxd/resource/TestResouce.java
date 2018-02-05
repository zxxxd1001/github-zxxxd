package git.zxxxd.resource;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class TestResouce {
    @GET
    public String  test(){
       return "hello";
    }
}
