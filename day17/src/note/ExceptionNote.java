package note;

/**
 * 异常的基本使用
 * @author Noby
 * @since 2023/3/18 17:44
 */
public class ExceptionNote {
    public static void main(String[] args) {
        //region 对于直接发生在main中且没有try catch的处理，会直接交给将异常抛给jvm，jvm会终止程序。如果异常经过try catch，将会继续运行程序
//        System.out.println(100 / 0);
        //endregion
        //region ArithmeticException 数学运算异常
        try {//如果程序发生异常且没有被处理，将会将异常抛给jvm，jvm会终止程序
            System.out.println(500 / 0);
            System.out.println("发生异常后，try中的异常代码后的代码不执行");
        } catch (ArithmeticException e) {//当一个try catch中存在多个catch时，执行其中一个catch后其他catch就不会继续执行
            //catch中写出处理异常的方式
            e.printStackTrace();//printStacktrace() 将异常信息打印出来
        } catch (Exception e) {//多个catch捕获多个异常，且子类异常在前,可以捕获Exception及其子类的异常
            System.out.println("这是一个Exception异常");
        } finally {
            System.out.println("finally中的代码不管异常是否发生都要执行的");
        }
        //endregion

        //region NullPointerException 空指针异常 ArrayIndexOutOfBoundsException 越界异常
        int[] arr = {1, 2, 3};
        try {
            method(arr, 3);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();//处理空指针异常和越界异常的方式，打印
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


    }

    /**
     * 异常的抛出和传递
     * 发生异常时，可通过throw抛出到方法的调用者（对于需要抛出的异常，需要在方法定义时给予声明），也可通过try catch处理异常
     * 对于运行时异常，在程序运行时才会被抛出，因此在方法声明中使用throws关键字声明这些异常并不能提高代码的安全性，反而会增加代码的冗余性和复杂性。可以在方法中省略运行时异常的声明。
     * 编译时异常不可省略异常的声明
     * @param arr
     * @param i
     * @throws NullPointerException
     * @throws ArrayIndexOutOfBoundsException
     */
    static void method(int[] arr, int i) throws NullPointerException{//声明可能产生的异常，运行时异常可以省略抛出
        //region throw 搭配 if-else 语句可用于异常的手动抛出。对于系统自带的异常，可以自动抛出（即只需在方法声明即可，出现异常自动抛出）
        if (arr == null) {
            throw new NullPointerException("自定义信息");//抛出一个空指针异常对象，并显示自定义提示信息，抛出异常表示让方法调用者处理
        }
        //这里的索引越界为系统异常，可省略抛出（上面的NullPointerException也可省略）
//        else if (arr.length - 1 < i || i < 0) {
//            throw new ArrayIndexOutOfBoundsException("手动抛出");//异常的创建用throw，异常的声明用throws
//        }
        else {
            System.out.println(arr[i]);
        }
        //endregion

        //region try-catch语句用于异常的处理
//        try {
//            System.out.println(arr[i]);
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        } catch (ArrayIndexOutOfBoundsException e) {
//            e.printStackTrace();
//        }
        //endregion
    }
}


class A {
    void method() throws Exception {
    }
}

/**
 * 异常在两个重写方法中的关系
 * 重写方法的异常范围小于等于被重写方法
 * @author Noby
 * @since 2023/3/18 17:45
 */
class B extends A {
    @Override
    void method() throws NullPointerException {
    }
}

/**
 * 类型转换异常
 * @author Noby
 * @since 2023/3/18 18:36
 */
class C extends A {
}
