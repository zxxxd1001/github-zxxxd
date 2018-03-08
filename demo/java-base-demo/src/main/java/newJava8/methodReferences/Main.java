package newJava8.methodReferences;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Main.s(Car::new);
    }

    /**
     * 方法引用和Lambda表达式配合使用，使得java类的构造方法看起来紧凑而简洁，没有很多复杂的模板代码。
     */
    public static void s(Supplier< Car > supplier ){
        System.out.println(supplier.toString());
    }
}
