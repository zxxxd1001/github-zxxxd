package newJava8.Interface;

public class JunitInterface {
    public static void main(String[] args) {
        TestInterface.testStatic();
        TestInterface t=new TestInterfaceImpl();
        t.testDefault();

        TestInterfaceImplTow tt=new TestInterfaceImplTow();
        tt.testDefault();
        tt.testStatic();
        System.out.println(tt.I);

        TestMultipleInterface.testStatic();
    }
}
