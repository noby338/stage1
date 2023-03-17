package note.generic;

import java.util.ArrayList;

/**
 * @Description 泛型的基本使用
 * @Author Noby
 * @Date 2023/3/17 21:51
 */
public class GenericNote {
    public static void main(String[] args) {

        //region 泛型类：使用了泛型的类
        GenericClass<String> stringGenericClass = new GenericClass<>();
        stringGenericClass.setVar("noby");
        System.out.println("stringGenericClass.getVar() = " + stringGenericClass.getVar());
        //endregion

        //region 泛型接口的实现类：接口泛型已定义
        new GenericInterfaceImpl1().methodInterface("noby");
        //endregion

        //region 泛型接口的实现类：接口泛型未定义
        new GenericInterfaceImpl2<Integer>().methodInterface(2);
        //endregion


        //region 泛型方法：使用了该类没有声明的泛型的方法
        concat("tow", 3);
        //endregion

        //region 泛型通配符
        /*
        ? 泛型通配符：表示该类型可以是任何数据类型
	    泛型通配符最常用的就是放在形参上接收不同类型的泛型对象
         */
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Object> objects = new ArrayList<>();
        method(strings);
        method0(objects);
        //endregion
    }

    /**
     * 泛型运用在方法上时，如果所使用的泛型没有在类中声明，则需要在方法中声明
     * 声明在返回值之前
     *
     * @param param
     * @param param2
     * @param <T1>
     * @param <T2>
     */
    static <T1, T2> void concat(T1 param, T2 param2) {
        System.out.println(param + "-" + param2);
    }

    static void method0(ArrayList<Object> list) {//Object并不是表示任意数据类型，而是只表示Object

    }

    static void method(ArrayList<?> list) {//可以存储任意数据类型

    }
}


/**
 * @Description 泛型运用在类上时，声明在类名之后
 * 如果某泛型已经在类中声明，则不需要在方法中额外声明，否则需在方法中额外声明
 * @Author Noby
 * @Date 2023/3/18 1:13
 */
class GenericClass<E> {//定义一个泛型类
    public E var;

    public GenericClass() {
    }

    public GenericClass(E var) {
        this.var = var;
    }

    public E getVar() {
        return var;
    }

    public void setVar(E var) {
        this.var = var;
    }
}

/**
 * @Description 泛型运用在接口中
 * @Author Noby
 * @Date 2023/3/18 1:15
 */
interface GenericInterface<E> {
    void methodInterface(E e);
}

/**
 * @Description 泛型运用在接口的实现类中，方式1，定义好接口的泛型
 * @Author Noby
 * @Date 2023/3/18 1:15
 */
class GenericInterfaceImpl1 implements GenericInterface<String> {//定义实现类的泛型的类型为字符串

    @Override
    public void methodInterface(String s) {
        System.out.println("实现类1的方法执行" + s);
    }
}

/**
 * @Description 泛型运用在接口的实现类中，方式2，实例化实现类时定义泛型的类型
 * @Author Noby
 * @Date 2023/3/18 1:16
 */
class GenericInterfaceImpl2<E> implements GenericInterface<E> {//实现类的泛型由创建对象时定义

    @Override
    public void methodInterface(E e) {
        System.out.println("实现类2的方法执行" + e);
    }
}





