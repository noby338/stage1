package note;

import java.util.LinkedList;

public class LinkedListNote {
    public static void main(String[] args) {
        //region 创建
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        System.out.println(integers);
        //endregion

        //region remove
        integers.removeFirst();//删除第一个元素
        integers.removeLast();//删除最后一个元素

        integers.remove(2);//删除第二个元素(list集合都带有索引)
        integers.remove(new Integer(2));//删除内容为2的元素
        //endregion

        integers.clear();
        integers.add(0);
        integers.add(0);
        integers.add(0);
        integers.add(0);

        //region addfirst()
        integers.addFirst(1);//添加到第一个元素
        integers.addLast(2);//添加到最后一个元素

        System.out.println(integers);
        //endregion
    }
}
