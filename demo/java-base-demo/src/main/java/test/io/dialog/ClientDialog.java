package test.io.dialog;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientDialog {
    private Socket socket;
    public ClientDialog(){
        try {
            System.out.println("正在尝试连接服务端...");
            socket = new Socket("localhost",12345);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            GetServerMessageHandler handler = new GetServerMessageHandler();
            new Thread(handler).start();

            Scanner scanner = new Scanner(System.in);
            OutputStream out = socket.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
            PrintWriter pw = new PrintWriter(osw,true);

            while(true){
                String message = scanner.nextLine();
                pw.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientDialog().start();
    }
    private class GetServerMessageHandler implements Runnable{
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in,"UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String message = null;
                while((message=br.readLine())!=null){
                    System.out.println(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
