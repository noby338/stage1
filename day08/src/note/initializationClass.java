package note;

/**
 * 类的生命周期
 */
public class initializationClass {
    public static void main(String[] args) {
//        System.out.println("Zi.name = " + Zi.name);
        /*
        被动引用：引用父类的静态字段，只会引起父类的初始化，而不会引起子类的初始化。
        Fu的静态代码块
        Zi.name = fuName
         */
        System.out.println();

        new Zi();
        /*
        Fu的静态代码块,Fu.name=null 静态变量在准备阶段附初值，该值非java程序中的值，而为jvm的默认值。java程序的赋值阶段在初始化阶段
        Zi的静态代码块
        Fu的非静态代码块
        Fu构造方法执行
        Zi的非静态代码块
        Zi构造方法执行
         */

        System.out.println();
        new Fu();
        /*
        前面在创建子类字节码文件对象时已经创建父类的而字节码文件对象，静态代码块仅在类初始化时才会执行，所以这里不会执行父类的静态代码块
        Fu的非静态代码块
        Fu构造方法执行
         */
    }

}

class Fu {
    private int age;//没有static修饰的成员变量或者成员方法都是类同非静态代码块 他们都是在创建对象时创建(构造函数之前)
    static {
        /*
        静态代码块的意义在于给静态变量赋初值，
        相比较直接在静态变量的声明后面赋初值，
        静态代码块可以根据逻辑语句给静态变量赋不同的初值
         */
        System.out.println("Fu的静态代码块，name="+Fu.name);
    }
    static String name = "fuName";//static修饰的成员变量或者成员方法都是在类的生命周期的准备阶段创建并附初值为null，而赋值阶段为初始化阶段，该阶段静态代码块和静态赋值语句都是顺序执行
    Fu() {
        System.out.println("Fu构造方法执行");
    }
    {
        System.out.println("Fu的非静态代码块");
    }

}

class Zi extends Fu{
    static {
        System.out.println("Zi的静态代码块");
    }
    {
        System.out.println("Zi的非静态代码块");
    }
    Zi() {
        System.out.println("Zi构造方法执行");
    }
}
