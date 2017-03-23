package git.zxxxd.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by zhangxuedong on 2017/3/23.
 */
public class MyClient extends HelloServlet {
    public  void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            String protocol = request.getScheme();
            String ip = request.getServerName();
            int port = request.getServerPort();
            String app = request.getContextPath();
            String host = protocol + "://" + ip + ":" + port + app + "/";
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Expires", "0");
            response.setContentType("application/x-java-jnlp-file");
            response.addHeader("Content-Disposition", "attachment; filename=myClient.jnlp");
            long date = new Date().getTime();
            response.addDateHeader("Last-Modified", date);

            PrintWriter out = response.getWriter();

            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
            //codebase 属性指出搜索应用程序资源的顶级URL,下面的icon/jar元素都是以这个URL为基本.
            out.println("<jnlp spec=\"6.0+\" codebase=\"" + host + "\" href=\"client\">");


            //配置信息
            out.println("<information>");
            // 在"开始"-"运行"菜单中输入"javaws"或"javaws -viewer"启动Web Start,会看到客户端已经安装的webstart应用程序
        /*
         * title ：应用程序标题
         * vendor：供应商title/vendor 元素必须，会显示在用"javaws -viewer"命令
         * 打开的应用程序缓存查看器（Java Application Cache Viewer）中
         */
            out.println("<title>MyClient</title>");
            out.println("<vendor>程序员</vendor>");
            //homepage ：存放有关应用程序的相关文档的URL，如help文件等，仅仅是description作用
            out.println("<homepage href=\"\"/>");
        /*
         * icon 指定图标会显示在应用程序缓存查看器中，
         * 在查看器中新建webstart快捷方式到桌面时也会显示为快捷方式图标，
         * 只支持GIF/JPEG格式，其它格式无效
         * <icon href="./images/logo.jpg"/>
         * 允许离线启动，可以使用javaws -offline命令
         * <offline-allowed/>
         */
            //描述
            out.println("<description>Device Client Web Start Version</description>");
            out.println("<description kind=\"short\">My Client Web Start Version</description>");
            //快捷方式
            out.println("<shortcut>");
            //创建桌面快捷方式
            out.println("<desktop/>");
            //指定菜单
            out.println("<menu submenu=\"My Corporation Apps\"/>");
            out.println("</shortcut>");
            out.println("</information>");
            //安全
//            out.println("<security>");
//            //运行所有权限
//            out.println("<all-permissions/>");
//            out.println("</security>");

            //程序更新设置
            out.println("<update check=\"always\" policy=\"always\"/>");

            //设置所需要的资源
            out.println("<resources>");
            //指定客户端需要安装的j2se版本，下面指定为1.7+，如果版本是1.6，在链接此jnlp文件时会提示更新j2se版本
            out.println("<j2se version=\"1.7+\"/>");
            //指定要下载到本地的jar文件(注意，所有的文件都需要打包才能够下载)，
            //可以包含一些资源文件，如icons/configuration files，可以使用getResource方法取得
            out.println("<jar href=\"/base/easySwing.jar\" version=\"1.0.3\"/>");
            //启动软件只执行一个更新检查以确保JNLP文件是最新的, 根据version判断是否更新
            //设置版本号后jar包名 需从DynamicTreeDemo.jar 改为 DynamicTreeDemo__V1.0.jar .
            //重点在于...__V1.0.jar
            out.println("<property name=\"jnlp.versionEnabled\" value=\"true\"/>");
            out.println("</resources>");

            //application-desc 必须，指定webstart启动时执行jar文件中的哪个类
            out.println("<application-desc main-class=\"HelloWorldSwing\">");
            //将参数传递给main方法
            out.println("<argument>" + "my test jnlp" + "</argument>");
            out.println("</application-desc>");

            out.println("</jnlp>");
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
