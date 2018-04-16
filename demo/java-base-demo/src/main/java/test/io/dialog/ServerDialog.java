package test.io.dialog;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerDialog {
    private ServerSocket serverSocket;
    private static int DEFAULT_PORT = 12345;
    private List<PrintWriter> allOut;
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    private int local=0;
    public ServerDialog() {
        this(DEFAULT_PORT);
    }
    public ServerDialog(int host){
        try {
            allOut=new ArrayList<>();
            serverSocket=new ServerSocket(host);
            System.out.println("服务器已启动，端口号：" + host);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start() throws IOException{
        try{
            while(true){
                System.out.println("等待链接。。。");
                Socket socket = serverSocket.accept();
                System.out.println("当前用户数："+(++local));
                executorService.execute(new ClientHandler(socket));
            }
        }finally{
            if(serverSocket != null){
                System.out.println("服务器已关闭。");
                serverSocket.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new ServerDialog().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private class ClientHandler implements Runnable{
        //当前线程交互的客户端的Socket
        private Socket socket;

        //客户端的地址信息
        private String host;

        public ClientHandler(Socket socket){
            this.socket = socket;
            //通过socket可以得知远端计算机信息
            InetAddress address = socket.getInetAddress();
            //获取远程计算机IP
            host = address.getHostAddress();
        }
        private synchronized void sendMessageToAllClient(String m){
            for(PrintWriter pw : allOut){
                pw.println(m);
            }
        }

        public void run() {
            PrintWriter pw = null;
            try {
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
                pw = new PrintWriter(osw,true);
                allOut.add(pw);
                sendMessageToAllClient(host+"  上线");

                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in,"UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String message = null;
                while((message = br.readLine())!=null){
                    sendMessageToAllClient(host+"说:"+message);
                }
            } catch (Exception e) {

            } finally{
                if(socket != null){
                    try {
                        socket.close();
                        allOut.remove(pw);
                        sendMessageToAllClient(host+"  下线");
                        --local;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
