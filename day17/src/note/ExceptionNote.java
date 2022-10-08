package note;

import java.util.ArrayList;

public class ExceptionNote {
    public static void main(String[] args) {
        //region ArithmeticException 数学运算异常
        try {//如果程序发生异常且没有被处理，将会将异常抛给jvm，jvm会终止程序
            System.out.println(500 / 0);
            System.out.println("发生异常后，try中的异常代码后的代码不执行");
        } catch (ArithmeticException                 e) {
            //catch中写出处理异常的方式
            e.printStackTrace();//printStacktrace() 将异常信息打印出来
        } catch (Exception e) {//多个catch捕获多个异常，且子类异常在前,可以捕获Exception及其子类的异常
            System.out.println("这是一个Exception异常");
        }
        finally {
            System.out.println("finally中的代码不管异常是否发生都要执行的");
        }
        //endregion

        //region NullPointerException 空指针异常 ArrayIndexOutOfBoundsException 越界异常
        int[] arr = {1, 2, 3};
        try {
            method(arr, 3);
        } catch (NullPointerException ex) {
            ex.printStackTrace();//处理空指针异常的方式
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();//处理越界异常的方式
        }
        //endregion

        //region ClassCastException 类型转换异常
        try {
            A b = new B();
            B b1 = (B) b;
            C b2 = (C) b;//ClassCastException 类型转换异常 b为B类型不能强转为C

        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        //endregion

        //region NumberFormatException 数字格式异常
        try {
            String strNum = "一二三";
            System.out.println(Integer.parseInt(strNum));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        //region


    }

    static void method(int[] arr, int i) throws NullPointerException, ArrayIndexOutOfBoundsException {//声明可能产生的异常，//异常的创建用throw，异常的声明用throws
        if (arr == null) {
            throw new NullPointerException("空指针异常");//当if条件成立时，抛出一个空指针异常对象，并显示提示信息，抛出异常表示让方法调用者处理
        } else if (arr.length - 1 < i || i < 0) {
            throw new ArrayIndexOutOfBoundsException("索引超出范围");//异常的创建用throw，异常的声明用throws
        }
        System.out.println(arr[i]);
    }
}

class A {
    void method() throws Exception{}
};

class B extends A{
    @Override
    void method() throws NullPointerException {}//子类的异常范围小于等于父类
};

class C extends A {
};
