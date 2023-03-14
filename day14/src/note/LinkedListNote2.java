package note;

import java.util.LinkedList;

public class LinkedListNote2 {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        //region 栈：先进后出。push()和pop()方法继承自Deque
        strings.push("one");
        strings.push("two");
        strings.push("three");

        System.out.println(strings.pop());//弹出栈的数据被删除 three
        System.out.println(strings);//[two, one]
        //endregion

        //region 队列：先进先出
        strings.clear();

        //offer()方法和add()方法都是将元素添加到最后，offer()为queue的方法，add()为list方法
        strings.offer("one");//入队列
        strings.offer("two");
        strings.offer("three");
//        strings.add("one");//入队列
//        strings.add("two");
//        strings.add("three");

        System.out.println(strings.poll());//出队列

        System.out.println(strings);//[two, three]
        //endregion
    }
}
