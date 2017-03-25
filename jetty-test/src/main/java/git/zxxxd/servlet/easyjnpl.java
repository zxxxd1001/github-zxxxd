package git.zxxxd.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * Created by zhangxuedong on 2017/3/25.
 */
public class easyjnpl extends HttpServlet {
    public  void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.setHeader("Pragma", "no-cache");
            resp.setHeader("Cache-Control", "no-cache");
            resp.setHeader("Expires", "0");
            resp.setContentType("application/x-java-jnlp-file");
            resp.addHeader("Content-Disposition", "attachment; filename=easy.jnlp");
            long date = new Date().getTime();
            resp.addDateHeader("Last-Modified", date);

            PrintWriter out = resp.getWriter();
            File file=new File("./src/main/java/git/zxxxd/jnplFile/easyjnpl.xml");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);

            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while((line = br.readLine())!=null){
                System.out.println(line);
               out.println(line);
            }
            isr.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
