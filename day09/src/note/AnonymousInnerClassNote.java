package note;

public class AnonymousInnerClassNote {//匿名内部类

    public static void main(String[] args) {
        //region 匿名内部类的使用
        /*
        该匿名内部类的字节码文件名为：
        AnonymousInnerClassNote$1.class
        该匿名类只能在本类中使用(AnonymousInnerClassNote)
         */
        A a = new A() {
            @Override
            public void method() {
                System.out.println("匿名内部类执行");
            }
        };
        a.method();
    }
}

abstract class A{
    public abstract void method();
}
