package hello.start;

import javax.swing.*;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Created by zhangxuedong on 2017/3/14.
 */
public class HelloWorldSwing {
    /**{
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    private static void createAndShowGUI() {
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建及设置窗口
        JFrame frame = new JFrame("hello.start.HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加 "Hello World" 标签
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        // 显示窗口
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(final String[] args) {

        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            public Object run() {
                UnchainedSecurityManager usm = new UnchainedSecurityManager();
                System.setSecurityManager(usm);
                return args;
            }
        });


        /* 显示应用 GUI */
        if(args!=null) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        SwingLoginExample s=new SwingLoginExample();
    }
}
