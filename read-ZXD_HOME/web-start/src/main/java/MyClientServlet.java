import javax.inject.Singleton;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by zhangxuedong on 2017/3/6.
 */
@Singleton
@WebServlet(urlPatterns = {"/my-client"})
public class MyClientServlet extends HttpServlet {

}
