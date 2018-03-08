package newJava8.repeatAnnotation;

import java.lang.annotation.*;

@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
@Repeatable( C.class )
public @interface A {
    String value();
}


@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
@interface C{
    A[] value();
}
