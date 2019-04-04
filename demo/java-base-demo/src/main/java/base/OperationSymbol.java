package base;

public class OperationSymbol {
    public static void main(String[] args) {
        int i=128,y=129;
        System.out.println(i&y);
        System.out.println(i|y);
        System.out.println(true&true);
        System.out.println(false&false);
        System.out.println(true&false);
        System.out.println(true|false);
        System.out.println(false|false);
        System.out.println(10&13);
        System.out.println(~10);
        System.out.println(10^13);
        int n=i >> 1;
        System.out.println(i>>2);
        byte c=1;
        System.out.println(Integer.toBinaryString(c));
        System.out.println(c<<2);
        System.out.println(c>>>2);
        System.out.println(Integer.toBinaryString(c>>>2));
        System.out.println(c>>2);
        System.out.println(Integer.toBinaryString(c>>2));

    }
}
