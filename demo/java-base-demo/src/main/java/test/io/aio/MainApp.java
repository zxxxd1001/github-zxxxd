package test.io.aio;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        //运行服务器
        ServerAio.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        Client.start();
        System.out.println("请输入请求消息：");
        Scanner scanner = new Scanner(System.in);
        while(Client.sendMsg(scanner.nextLine()));
    }
}
