package note;

public class InterfaceNote {//接口

    public static void main(String[] args) {
        /*
        默认方法不可直接直接被接口调用
         */
//        Usb.method();
        Usb.method1();
        new Earphone().method();
    }
}

class Earphone implements Usb {

    @Override
    public void read() {

    }

    /*
    默认方法可不必实现
     */
//    @Override
//    public void method() {
//        Usb.super.method();
//    }

    /*
    静态方法不能被实现
     */
//    @Override
//    public static void method1() {
//
//    }

}

interface Usb {
    /*
    接口中的所有成员默认都由public修饰
     */
    //region 成员变量
    /*
    接口中的所有属性都默认由 public static final 修饰(都是静态常量)
     */
//    public String name;//因为被final修饰，所以必须赋初值
    //endregion

    //region 成员方法
    /*
    接口里面的所有方法都默认由 public abstract 修饰(都是抽象方法)
    接口里的所有方法不可由final修饰
     */
    public void read();
    //endregion

    //region 接口中可以有实现方法，他们必须由static或者default修饰
    public default void method() {
        System.out.println("usb.method");
    }

    public static void method1() {
        System.out.println("usb.method1");
    }
    //endregion

}

