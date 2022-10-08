package note;

public class initializationClass {//继承关系类的初始化
    public static void main(String[] args) {
        new Zi();
        /*
        Fu的静态代码块 静态代码块在字节码文件对象创建时即会创建
        Zi的静态代码块
        Fu的非静态代码块
        Fu构造方法执行
        Zi的非静态代码块
        Zi构造方法执行
         */

        System.out.println();
        new Fu();
        /*
        前面在创建子类字节码文件对象时已经创建父类的而字节码文件对象(静态代码块仅在创建字节码文件对象时才会创建)，所以不会执行 父类的静态代码块
        Fu的非静态代码块
        Fu构造方法执行
         */
    }

}

class Fu {
    private static String name;//static修饰的成员变量或者成员方法都是类同静态代码块 他们都是在创建字节码文件对象时创建
    private int age;//没有static修饰的成员变量或者成员方法都是类同非静态代码块 他们都是在创建对象时创建(构造函数之前)
    static {
        /*
        静态代码块的意义在于给静态变量赋初值，
        相比较直接在静态变量的声明后面赋初值，
        静态代码块可以根据逻辑语句给静态变量赋不同的初值
         */
        System.out.println("Fu的静态代码块");
    }
    {
        System.out.println("Fu的非静态代码块");
    }
    Fu() {
        System.out.println("Fu构造方法执行");
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
