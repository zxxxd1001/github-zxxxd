package test.myHttp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
    private static ServerSocket server;
    private static Properties properties= new Properties();
    private int port;

    static {
        try {
            properties.load(new FileInputStream(new File(Server.class.getResource("/").getPath()+"../../resources/main/config.properties")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        try {
            port = Integer.parseInt(properties.getProperty("port"));
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receive() {
        try {
            Socket clientSocket = server.accept();
            System.out.println("接受一个请求："+clientSocket.getInetAddress().getHostAddress());
            Thread thread = new Thread(new ServerThread(clientSocket));
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server Aaroncat = new Server();
        Aaroncat.init();
        System.out.println("----Aaroncat has startup----");
        while (true) {
            Aaroncat.receive();
        }
    }
    private class ServerThread implements Runnable{
        private Socket clientSocket;
        private Request request;
        private Response response;

        ServerThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public Socket getClientSocket() {
            return clientSocket;
        }

        public void setClientSocket(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public Request getRequest() {
            return request;
        }

        void setRequest(Request request) {
            this.request = request;
        }

        public Response getResponse() {
            return response;
        }

        public void setResponse(Response response) {
            this.response = response;
        }

        public void run(){
            System.out.println(Thread.currentThread().getName());
            try {
                this.setRequest(new Request(clientSocket));
                this.response = new Response(request,properties);
                this.setResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}