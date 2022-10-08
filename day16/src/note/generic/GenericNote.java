package note.generic;

import java.util.ArrayList;

public class GenericNote {//泛型
    public static void main(String[] args) {
        /*
         * 	泛型最大的两个作用：
         * 		约束值的类型：在创建对象时只要是指定了类型，那么赋值的数据就必须是该类型及其子类型的数据
         * 		自动结合上下文知道泛型是什么类型，自动知道可用调用哪些方法
         *
         * 		避免了把问题放到运行时，在编写代码时就直接报错
         */

        //region 泛型方法：使用了泛型的方法
        concat("tow", 3);
        //endregion

        //region 泛型类：使用了泛型的类
        Box<String> box = new Box<>();//泛型类在创建对象时指定泛型的具体类型
        box.data = "info";
        Box box1 = new Box();//泛型类在创建时也可以不指定泛型的具体类型
        box1.data = "info";
        System.out.println(box1.data);
        //endregion

        //region 泛型通配符
        /*
        ? 泛型通配符：表示该类型可以是任何数据类型
	    泛型通配符最常用的就是放在形参上接收不同类型的泛型对象
         */
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Object> objects = new ArrayList<>();
        method(strings);
        method1(integers);
        method2(objects);
        method0(objects);
        //endregion
    }

    private static void method2(ArrayList<? super String> list) {//可以存储String及其父类的数据类型
        //泛型上界
    }

    private static void method1(ArrayList<? extends Number> list) {//可以存储number及其子类的数据类型
        //泛型下界
    }

    private static void method(ArrayList<?> list) {//可以存储任意数据类型

    }

    private static void method0(ArrayList<Object> list) {//Object并不是表示任意数据类型，而是只表示Object

    }



    static <T1,T2> void concat(T1 num1, T2 num2) {
        System.out.println(num1 + "-" +num2);
    }
}

class Box<T> {//泛型类
    T data;//指定该属性为泛型(数据类型由创建对象时确定)
}


