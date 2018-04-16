package test.jdkHttp;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;

public class HttpResponse{
    private HttpExchange httpExchange;

    public HttpResponse(HttpExchange httpExchange){
        this.httpExchange = httpExchange;
    }

    public void write(String result) {
        try {
            httpExchange.sendResponseHeaders(200, result.length());// 设置响应头属性及响应信息的长度
            OutputStream out = httpExchange.getResponseBody(); // 获得输出流
            out.write(result.getBytes());
            out.flush();
            httpExchange.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
