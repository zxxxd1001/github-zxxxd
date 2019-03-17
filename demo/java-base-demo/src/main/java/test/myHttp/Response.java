package test.myHttp;
import test.myHttp.utils.FileUtil;
import test.myHttp.utils.LoginUtil;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class Response {

    private String fileName;
    private Map<String, String> userValues;
    private PrintStream ps;
    private Request request;
    private Socket clientSocket;
    private Properties properties;

    protected FileUtil fileUtil = new FileUtil();
    protected LoginUtil loginUtil = new LoginUtil(properties);

    public String getFileName() {
        return fileName;
    }

    public Response(Request request , Properties properties) {
        this.setRequest(request);
        this.setClientSocket(request.getSocket());
        this.setFileName(request.getRequestFileName());
        this.properties=properties;
        userValues = this.request.getSocketValues();

        try {
            this.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showup(String fileName) throws IOException {
        this.ps = this.request.getPrint();
        // 要处理正常文件名和空文件名
        if (!fileName.equals("")  && !fileName.equals("error.html")) {
            this.ps.println("HTTP/1.1 200 OK");
            this.ps.println();
            fileUtil.readFile(fileName, ps);
        } else if (fileName.equals("error.html")) {
            ps.println("HTTP/1.1 404 fileNotFound");
            ps.println();
            fileUtil.readFile("error.html", ps);
        } else {
            ps.println(new Date().toString());
        }
        if (ps != null){
            ps.close();
        }
    }

    public void init() throws IOException {
        //如果信息MAP是空，则代表是普通文件或者是默认访问
        if (userValues.isEmpty()) {
            if (fileName != "") {
                this.showup(fileName);
            } else {
                this.ps = this.request.getPrint();
                ps.println(new Date().toString());
                if(ps != null) ps.close();
                if(clientSocket != null)clientSocket.close();
            }
        } else {
            //如果信息MAP不为空，代表是GET/POST请求，并带有参数键值对
            this.Check(userValues, fileName);
        }

    }

    public void Check(Map<String, String> values_list, String respFileName) throws IOException {
        // 验证用户输入信息的合法性
        if (loginUtil.isValid(values_list)) {
            this.showup(respFileName);
        } else {
            this.showup("error.html");
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, String> getUserValues() {
        return userValues;
    }

    public void setUserValues(Map<String, String> userValues) {
        this.userValues = userValues;
    }

    public PrintStream getPs() {
        return ps;
    }

    public void setPs(PrintStream ps) {
        this.ps = ps;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
}