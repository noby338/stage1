package note;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class VectorNote {//向量
    public static void main(String[] args) {
        Vector<Integer> integers = new Vector<>();
        Collections.addAll(integers,1,2,3,4,5);

        //region Vector通过枚举器遍历
        /*
        迭代器存在安全问题,不推荐
         */
        /*
         * 快速失败：就是在原有的数据结构上进行遍历,当某个程序修改了原有的数据结构，如果当前程序继续遍历结构会快速失败（不允许继续遍历）
         * 	迭代器：快速失败
         *
         * 安全失败：在副本（克隆、备份）上进行遍历,即使另一个程序修改原有的数据结构也会不影响到当前程序的遍历
         * 	枚举器：安全失败
         *
         * ArrayList：无参构造得到的数据长度为0，第一次放数据时才会创建长度为10的数组
         * 			ArrayList默认扩容为原来的1.5倍
         * Vector：默认长度就是10
         * 			Vector默认扩容为原来的2倍
         */

        Enumeration<Integer> elements = integers.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
        //endregion
    }
}
