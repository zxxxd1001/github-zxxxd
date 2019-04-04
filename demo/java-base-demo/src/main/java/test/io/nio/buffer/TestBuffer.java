package test.io.nio.buffer;

import java.nio.ByteBuffer;

public class TestBuffer {
    public static void main(String[] args) {
        ByteBuffer b=ByteBuffer.allocate(1024);
        System.out.println(b);
        b.put("abc".getBytes());
        System.out.println("abc".getBytes());
        System.out.println(b);
        b.flip();
        byte [] c=new byte[b.limit()];
        b.get(c);
        System.out.println(new String(c));
    }
}
