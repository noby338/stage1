package note;
/**
 * 内部类
 */
public class InnerClassNote {

    public static void main(String[] args) {
        Outer outer = new Outer();


        //region 非静态内部类
        Outer.Inner inner = outer.new Inner();
        System.out.println(inner.age);
        //endregion

        //region 静态内部类
        Outer.StaticInner staticInner = new Outer.StaticInner();
        System.out.println(staticInner.name);
        System.out.println(Outer.StaticInner.age);
        //endregion
    }
}

//region
/*
内部类：一个类的声明在另一个类里面
    非静态内部类：当做非静态方法对待
    静态内部类：当做静态方法对待
外部类：包含内部类的类
Inner类的class文件名为：Outer$Inner.class
 */
class Outer {
    class Inner {
        //region 在非静态内部类中不能包含静态方法和静态变量
//        public static int age;
//        public static void methodStaticInner() {
//
//        }
        //endregion
        public int age;

        public void methodInner() {
            System.out.println("非静态内部类方法");
        }
    }

    static class StaticInner {
        //region 在静态内部类中能包含静态方法和静态变量
        public static int age;
        public static void methodStaticInner() {
            System.out.println("静态内部类静态方法");
        }
        //endregion

        //region 在非静态内部类中能包含成员方法和成员变量
        public String name;
        public void methodInner() {
            System.out.println("静态内部类非静态方法");
        }
        //endregion
    }
}
//endregion

