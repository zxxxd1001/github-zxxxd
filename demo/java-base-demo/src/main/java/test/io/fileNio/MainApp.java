package test.io.fileNio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * FileChannel 不能设置非阻塞
 */

public class MainApp {
    public static void main(String[] args) throws Exception {
        String url=MainApp.class.getResource("/").getPath()+"../../resources/main/text.txt";
        MainApp c=new MainApp();
        c.fileNio(url);
    }
    public void fileNio(String url){
        try {
            FileInputStream fileInputStream=new FileInputStream(url);
            File io=new File("/Users/zhangxuedong/work/mac/text1.txt");
            if(!io.isFile()){
                io.createNewFile();
            }
            FileOutputStream fileOutputStream=new FileOutputStream(io);
            FileChannel fileChannel=fileInputStream.getChannel();
            FileChannel channel=fileOutputStream.getChannel();
            //设置buffer大小
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            int y=fileChannel.read(byteBuffer);
            int bytesRead = fileChannel.read(byteBuffer);
            Charset latin1 = Charset.forName( "UTF-8" );
            CharsetDecoder decoder = latin1.newDecoder();
            CharsetEncoder encoder = latin1.newEncoder();
            while (bytesRead!=-1) {
                System.out.println("Read " + bytesRead);
                //flip方法将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，并将limit设置成之前position的值
                byteBuffer.flip();

                while(byteBuffer.hasRemaining()){
    //                char c=(char) byteBuffer. get();
//                    System.out.print(decoder.decode(byteBuffer));
                    channel.write(byteBuffer);
                }

                System.out.println();
                byteBuffer.clear();
                bytesRead = fileChannel.read(byteBuffer);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
