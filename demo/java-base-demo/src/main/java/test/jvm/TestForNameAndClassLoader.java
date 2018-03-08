package test.jvm;

public class TestForNameAndClassLoader {
    public static void main(String[] args) {
        try {
            Class cc=Class.forName("test.jvm.A");
            Class c=B.class.getClassLoader().loadClass("test.jvm.B");
            c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
