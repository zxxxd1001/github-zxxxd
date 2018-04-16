package test.jdkHttp;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {
    //启动服务，监听来自客户端的请求
    public static void start() throws IOException {
        Context.load();
        //监听端口8080,能同时接 受100个请求
        HttpServer httpserver =HttpServer.create(new InetSocketAddress(8080), 100);
        httpserver.createContext(Context.contextPath, new MyHandler());
        httpserver.setExecutor(Executors.newFixedThreadPool(100));
        httpserver.start();
        System.out.println("server started");
    }


    public static void main(String[] args) throws IOException {
        start();
    }

}
class MyHandler implements HttpHandler {
    public void handle(HttpExchange httpExchange) throws IOException {
        HttpRequest request = new HttpRequest(httpExchange);
        HttpResponse response = new HttpResponse(httpExchange);
        Context.getHandler(request.getReuestURI().getPath()).service(request, response);
    }
}
