package test.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {
    public static void main(String[] args) {
        TestChannel t=new TestChannel();
        t.testChannel();
        t.testOpenChannel();
    }
    private void testOpenChannel() {
        FileChannel in=null;
        FileChannel out=null;
        try {
            System.out.println(this.getClass().getResource("./").getPath());
            in=FileChannel.open(Paths.get("src/main/java/test/io/test.txt"),StandardOpenOption.READ);
            out=FileChannel.open(Paths.get("src/main/java/test/io/test1.txt"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
          //通道之间的传输
            in.transferTo(0,in.size(),out);
            out.transferFrom(in,0,in.size());
            //通过内存复制拷贝剪切
//            MappedByteBuffer b=in.map(FileChannel.MapMode.READ_ONLY,0,in.size());
//            MappedByteBuffer o=out.map(FileChannel.MapMode.READ_WRITE,0,in.size());
//            while (b.hasRemaining()){
//                o.put(b.get());
//                System.out.println((char)b.get());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void testChannel(){
        try {
            /*
             * FileChannel：从文件中读写数据。
             * DatagramChannel：能通过UDP读写网络中的数据。
             * SocketChannel：能通过TCP读写网络中的数据。
             * ServerSocketChannel：可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。
             */
            RandomAccessFile randomAccessFile=new RandomAccessFile("src/main/java/test/io/test.txt","rw");
            //读取到文件
            FileChannel f=randomAccessFile.getChannel();
            ByteBuffer b=ByteBuffer.allocate(48);
            //读取数据到buffer
            int i=f.read(b);
            while (i!=-1) {
                System.out.println("read:"+i);
                //将Buffer从写模式切换到读模式。在读模式下，可以读取之前写入到buffer的所有数据
                b.flip();
                while(b.hasRemaining()){
                    System.out.print((char) b.get());
                }
                System.out.println();
                //clear清空整个缓冲区。
                //compact只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处
                b.clear();
                i = f.read(b);
                System.out.println("read:"+i);
            }
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
