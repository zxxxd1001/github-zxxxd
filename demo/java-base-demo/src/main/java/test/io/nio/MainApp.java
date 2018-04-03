package test.io.nio;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception{
        //运行服务器
        ServerNio.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        Client.start();
        while(Client.sendMsg(new Scanner(System.in).nextLine()));
    }
}
