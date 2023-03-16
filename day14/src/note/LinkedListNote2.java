package note;

import java.util.LinkedList;
/**
 * @Description 实现队列和栈的数据结构
 * @Author Noby
 * @Date 2023/3/16 19:38
 */
public class LinkedListNote2 {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        //region 栈：先进后出。push()(添加到第一个，没有返回值)和pop()(删除第一个，返回被删除的值)方法继承自Deque(双端队列)
        strings.push("one");
        strings.push("two");
        strings.push("three");
        System.out.println("strings = " + strings);//strings = [three, two, one]
        System.out.println("strings.pop() = " + strings.pop());//strings.pop() = three

        System.out.println("strings = " + strings);//strings = [two, one]
        //endregion

        strings.clear();

        //region 队列：先进先出。offer()(添加到最后一个，返回boolean)，poll()(删除第一个，返回删除对象)，方法继承自Queue(队列)的方法，Queue实现了Deque
        System.out.println("strings.offer(\"one\") = " + strings.offer("one"));//strings.offer("one") = true
        System.out.println("strings.offer(\"two\") = " + strings.offer("two"));//strings.offer("two") = true
        System.out.println("strings.offer(\"three\") = " + strings.offer("three"));//strings.offer("three") = true
        System.out.println("strings = " + strings);//strings = [one, two, three]
        System.out.println("strings.poll() = " + strings.poll());//strings.poll() = one

        System.out.println("strings = " + strings);//strings = [two, three]
        //endregion
    }
}
