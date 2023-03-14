package note.annotation;

import java.lang.annotation.*;

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface Jdbc {
    //注解中的属性
    String driver() default "com.mysql.jdbc.Driver";//default表示注解中的默认值

    String url() default "jdbc:mysql://localhost:3306/java87";

    String username() default "root";

    String pwd() default "123";

}
