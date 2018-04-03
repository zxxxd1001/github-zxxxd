package ClassLoader;

/**
 * 从字面的角度解释是这样的：什么是嵌套？
 * （真TM猥琐）。
 * 什么是内部？内部就是我是你的一部分，我了解你，我知道你的全部，没有你就没有我。
 * （所以内部类对象是以外部类对象存在为前提的）
 */
public class OuterClass {
    //静态嵌套类
    //嵌套就是我跟你没关系，自己可以完全独立存在，但是我就想借你的壳用一下，来隐藏一下我自己
    private static class Inner extends A{
        static {
            System.out.println("TestInner Static!");
        }
        public final static OuterClass testInstance = new OuterClass(3);
    }
    //内部类
    //内部就是我是你的一部分，我了解你，我知道你的全部，没有你就没有我。
    public class Inners extends A{
        public Inners(){

        }
        public void p(){
            test();
        }
    }

    public static OuterClass getInstance(){
        return Inner.testInstance;
    }
    public void test(){
        System.out.println("A");
    }

    public OuterClass(int i ) {
        System.out.println("Test " + i +" Construct! ");
    }
    //类静态属性
    public static OuterClass testOut = new OuterClass(1);
    //类静态块
    static {
        System.out.println("Test Static");
    }

    public static void main(String args[]){
        OuterClass t = new OuterClass(2);
        OuterClass.getInstance();
        Inners i=t.new Inners();
        i.p();
    }
}
class A{

}