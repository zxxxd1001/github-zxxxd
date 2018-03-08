package newJava8.repeatAnnotation;

public class RepeatingAnnotations {

    public static void main(String[] args) {
        for( A a: B.class.getAnnotationsByType( A.class ) ) {
            System.out.println( a.value() );
        }
    }
}
