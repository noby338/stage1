package note.annotation.anno;

import java.lang.annotation.*;

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Jdbc {
    //注解中的属性，默认为public
    String driver() default "com.mysql.jdbc.Driver";//default表示注解中的默认值

    String url() default "jdbc:mysql://localhost:3306/stage1";

    String username() default "root";

    String pwd() default "123";

}
