package note.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型通配符的基本使用
 * 通配符可以用于限制泛型类型的范围
 * @author Noby
 * @since 2023/3/17
 */
public class GenericWildcardNote {

    public static void main(String[] args) {
        //region 无界通配符
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        printList(intList);

        List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("World");
        strList.add("!");
        printList(strList);
        //endregion

        //region 上界通配符
//        method1(strList);
        method1(intList);
        //endregion

        //region 下界通配符
        method2(strList);
        //endregion

    }

    /**
     * 无界通配符
     * 定义一个打印集合参数的方法
     *
     * @param list
     */
    static void printList(List<?> list) {
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }


    /**
     * 上界通配符
     * 可以存储number及其子类的数据类型
     *
     * @param list
     */
    static void method1(List<? extends Number> list) {
    }

    /**
     * 下界通配符
     * 可以存储String及其父类的数据类型
     *
     * @param list
     */
    static void method2(List<? super String> list) {
    }
}
