package git.zxxxd.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HelloController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello(HttpServletRequest request){
        System.out.println(request.getParameter("name"));
        return "hello spring mvc!";
    }

    @RequestMapping("testJson")
    @ResponseBody
    public TestJson testJson(){
        return new TestJson();
    }
}
