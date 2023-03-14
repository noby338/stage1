package note.annotation;

public class AnnotationNote {//注解

    public static void main(String[] args) {
        //region 利用注解给对象赋值 方式1：注解写在对象上
        DataSource dataSource = JdbcUtil.GetInstance(DataSource.class);
        System.out.println(dataSource);
        //endregion

        //region 利用注解给对象赋值 方式2：注解写在属性上
        dataSource = JdbcUtil.GetInstance2(DataSource.class);
        System.out.println(dataSource);
        //endregion

    }
}
/*
 * 注解：是一种特殊的Java对象，常见的Java对象有四种：class、interface、enum、annotation
 * 注解就是一种标记，标记一段代码让编译器知道该对这段代码做什么事
 * 自定义注解
 *
 * 在Java中有四个元注解，这几个注解是用来修饰自定义注解的
 * @Target：表示自定义注解能够在哪些地方使用
 * 		FIELD：可以在属性上使用
 * 		METHOD：可以在方法上
 * 		TYPE：可以在类上使用
 * @Retention：指定自定义注解能在什么时候访问到、能够保留到什么时候
 * 		source：只在源代码中能保留，在编译时会自动抹掉
 * 		class：能在源代码、class文件中保留，但是程序执行会被忽略，运算时就没了
 * 		runtime：可以保留到运行时，在运行时可以解析到该注解
 * @Documented：加上该注解表明自定义的注解可以出现doc文档中
 * @Inherited：继承，如果父类使用了自定的注解，那么子类也会将注解继承过去
 *
 */

