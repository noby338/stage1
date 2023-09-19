package note;

import java.util.LinkedList;

/**
 * LinkedList的基本用法
 * @author Noby
 * @since 2023/3/16 19:02
 */
public class LinkedListNote {
    public static void main(String[] args) {
        //region 创建
        LinkedList<Integer> integers = new LinkedList<>();
        System.out.println("integers.add(1) = " + integers.add(1));//integers.add(1) = true
        System.out.println("integers.add(2) = " + integers.add(2));//integers.add(2) = true
        System.out.println("integers.add(3) = " + integers.add(3));//integers.add(3) = true
        System.out.println("integers.add(4) = " + integers.add(4));//integers.add(4) = true
        System.out.println("integers.add(6) = " + integers.add(6));//integers.add(6) = true
        integers.add(4,5);//没有返回值

        System.out.println("integers = " + integers);//integers = [1, 2, 3, 4, 5, 6]
        //endregion

        //region remove
        System.out.println("integers.removeFirst() = " + integers.removeFirst());//integers.removeFirst() = 1
        System.out.println("integers.removeLast() = " + integers.removeLast());//integers.removeLast() = 5

        System.out.println("integers.remove(2) = " + integers.remove(2));//integers.remove(2) = 4
        System.out.println("integers.remove(new Integer(2)) = " + integers.remove(new Integer(2)));//integers.remove(new Integer(2)) = true
        System.out.println("integers = " + integers);//integers = [3]
        //endregion

        integers.clear();
        System.out.println("integers.add(0) = " + integers.add(0));//integers.add(0) = true
        System.out.println("integers.add(0) = " + integers.add(0));//integers.add(0) = true

        //region add
        integers.addFirst(1);//添加到第一个元素，没有返回值
        integers.addLast(2);//添加到最后一个元素，没有返回值

        System.out.println("integers = " + integers);//integers = [1, 0, 0, 2]
        //endregion
    }
}
