package newJava8.typeInference;

public class TypeInference {
    public static void main(String[] args) {
        final Value< String > value = new Value<>();
        System.out.println(value.getOrDefault("22", Value.defaultValue()));
    }
}
