package git.zxxxd;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class TestPath {
    @GET
    public void test(){
        System.out.println("test");
    }
}
