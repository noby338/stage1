package note;

/**
 * 匿名内部类
 */
public class AnonymousInnerClassNote {

    public static void main(String[] args) {
        //region 匿名内部类的使用
        /*
        该匿名内部类的字节码文件名为：
        AnonymousInnerClassNote$1.class
        该匿名类只能在本类中使用(AnonymousInnerClassNote)
         */
        A a = new A() {
            @Override
            public void methodA() {
                System.out.println("匿名内部类执行A");
            }
        };
        a.methodA();

        /*
        该匿名内部类的字节码文件名为：
        AnonymousInnerClassNote$2.class
        该匿名类只能在本类中使用(AnonymousInnerClassNote)
         */
        new B(){
            @Override
            public void methodB() {
                System.out.println("匿名内部类执行B");
            }
        }.methodB();
        //endregion
    }
}

abstract class A{
    public abstract void methodA();
}

interface B{
    void methodB();
}
