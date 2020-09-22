package jvm.betycode;

public class TryFinally {
    public static void main(String[] args) {
        System.out.println(f1());
    }
    /**
     public static java.lang.String f1();
     descriptor: ()Ljava/lang/String;
     flags: ACC_PUBLIC, ACC_STATIC
     Code:
     stack=1, locals=3, args_size=0
     0: ldc           #34                 // String hello
     2: astore_0
     3: aload_0
     4: astore_2
     5: ldc           #36                 // String imooc
     7: astore_0
     8: aload_2
     9: areturn
     10: astore_1
     11: ldc           #36                 // String imooc
     13: astore_0
     14: aload_1
     15: athrow
     * */
    public static String f1() {
        String str = "hello";
        try{
            return str;
        }
        finally{
            str = "imooc";
        }
    }
}
//Classfile /Users/zhangxuedong/work/github-zxxxd/demo/java-base-demo/out/production/classes/jvm/betycode/TryFinally.class
//Last modified 2020-6-23; size 810 bytes
//        MD5 checksum 545a56939f8de84200f1b5a3137a606d
//        Compiled from "TryFinally.java"
//public class jvm.betycode.TryFinally
//        minor version: 0
//        major version: 52
//        flags: ACC_PUBLIC, ACC_SUPER
//        Constant pool:
//        #1 = Methodref          #8.#29         // java/lang/Object."<init>":()V
//        #2 = Fieldref           #30.#31        // java/lang/System.out:Ljava/io/PrintStream;
//        #3 = Methodref          #7.#32         // jvm/betycode/TryFinally.f1:()Ljava/lang/String;
//        #4 = Methodref          #33.#34        // java/io/PrintStream.println:(Ljava/lang/String;)V
//        #5 = String             #35            // hello
//        #6 = String             #36            // imooc
//        #7 = Class              #37            // jvm/betycode/TryFinally
//        #8 = Class              #38            // java/lang/Object
//        #9 = Utf8               <init>
//  #10 = Utf8               ()V
//          #11 = Utf8               Code
//          #12 = Utf8               LineNumberTable
//          #13 = Utf8               LocalVariableTable
//          #14 = Utf8               this
//          #15 = Utf8               Ljvm/betycode/TryFinally;
//          #16 = Utf8               main
//          #17 = Utf8               ([Ljava/lang/String;)V
//          #18 = Utf8               args
//          #19 = Utf8               [Ljava/lang/String;
//          #20 = Utf8               f1
//          #21 = Utf8               ()Ljava/lang/String;
//          #22 = Utf8               str
//          #23 = Utf8               Ljava/lang/String;
//          #24 = Utf8               StackMapTable
//          #25 = Class              #39            // java/lang/String
//          #26 = Class              #40            // java/lang/Throwable
//          #27 = Utf8               SourceFile
//          #28 = Utf8               TryFinally.java
//          #29 = NameAndType        #9:#10         // "<init>":()V
//          #30 = Class              #41            // java/lang/System
//          #31 = NameAndType        #42:#43        // out:Ljava/io/PrintStream;
//          #32 = NameAndType        #20:#21        // f1:()Ljava/lang/String;
//          #33 = Class              #44            // java/io/PrintStream
//          #34 = NameAndType        #45:#46        // println:(Ljava/lang/String;)V
//          #35 = Utf8               hello
//          #36 = Utf8               imooc
//          #37 = Utf8               jvm/betycode/TryFinally
//          #38 = Utf8               java/lang/Object
//          #39 = Utf8               java/lang/String
//          #40 = Utf8               java/lang/Throwable
//          #41 = Utf8               java/lang/System
//          #42 = Utf8               out
//          #43 = Utf8               Ljava/io/PrintStream;
//          #44 = Utf8               java/io/PrintStream
//          #45 = Utf8               println
//          #46 = Utf8               (Ljava/lang/String;)V
//          {
//public jvm.betycode.TryFinally();
//        descriptor: ()V
//        flags: ACC_PUBLIC
//        Code:
//        stack=1, locals=1, args_size=1
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//        LineNumberTable:
//        line 3: 0
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        0       5     0  this   Ljvm/betycode/TryFinally;
//
//public static void main(java.lang.String[]);
//        descriptor: ([Ljava/lang/String;)V
//        flags: ACC_PUBLIC, ACC_STATIC
//        Code:
//        stack=2, locals=1, args_size=1
//        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
//        3: invokestatic  #3                  // Method f1:()Ljava/lang/String;
//        6: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//        9: return
//        LineNumberTable:
//        line 5: 0
//        line 6: 9
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        0      10     0  args   [Ljava/lang/String;
//
//public static java.lang.String f1();
//        descriptor: ()Ljava/lang/String;
//        flags: ACC_PUBLIC, ACC_STATIC
//        Code:
//        stack=1, locals=3, args_size=0
//        0: ldc           #5                  // String hello
//        2: astore_0
//        3: aload_0
//        4: astore_1
//        5: ldc           #6                  // String imooc
//        7: astore_0
//        8: aload_1
//        9: areturn
//        10: astore_2
//        11: ldc           #6                  // String imooc
//        13: astore_0
//        14: aload_2
//        15: athrow
//        Exception table:
//        from    to  target type
//        3     5    10   any
//        LineNumberTable:
//        line 28: 0
//        line 30: 3
//        line 33: 5
//        line 30: 8
//        line 33: 10
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        3      13     0   str   Ljava/lang/String;
//        StackMapTable: number_of_entries = 1
//        frame_type = 255 /* full_frame */
//        offset_delta = 10
//        locals = [ class java/lang/String ]
//        stack = [ class java/lang/Throwable ]
//        }
//        SourceFile: "TryFinally.java"
