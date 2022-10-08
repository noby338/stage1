package note;

import java.util.Collections;
import java.util.LinkedList;

public class Stack_queuesNote {//栈和队列
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        //region 栈：先进后出
        strings.push("one");//push addFirst 方法相同
        strings.push("tow");
        strings.addFirst("three");
        System.out.println(strings);
        System.out.println(strings.pop());//弹出栈的数据被删除 等同于removeFirst
        System.out.println(strings);//[tow, one]
        //endregion

        System.out.println();
        //region 队列：先进先出
        strings.clear();

        strings.offer("one");//入队列 offer add addLast 方法相同
        strings.add("tow");
        strings.addLast("three");

        System.out.println(strings);

        System.out.println(strings.poll());//出队列  等同于removeFirst

        System.out.println(strings);//[tow, three]
        //endregion

        System.out.println();
        LinkedList<String> info = new LinkedList<>();
        Collections.addAll(info,"one","tow","three","four");
        System.out.println(info);
        info.poll();
        info.pop();
        System.out.println(info);
    }
}
