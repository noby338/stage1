package note;

import java.util.*;
import java.util.function.Predicate;

/**
 * ArrayList的基本用法
 * @author Noby
 * @since 2023/3/16 19:01
 */
public class ArrayListNote {
    public static void main(String[] args) {
        //region 创建
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> strings1 = new ArrayList<>();
        //endregion

        //region 成员方法
        System.out.println("strings.add(\"str1\") = " + strings.add("str1"));//strings.add("str1") = true
        System.out.println("strings.add(\"str2\") = " + strings.add("str2"));//strings.add("str2") = true
        System.out.println("strings.add(\"str3\") = " + strings.add("str3"));//strings.add("str3") = true
        System.out.println("strings.add(\"str5\") = " + strings.add("str5"));//strings.add("str5") = true
        strings.add(3,"str4");//没有返回值

        System.out.println("strings1.add(\"string1\") = " + strings1.add("string1"));//strings1.add("string1") = true
        System.out.println("strings1.add(\"string2\") = " + strings1.add("string2"));//strings1.add("string2") = true
        System.out.println("strings.addAll(strings1) = " + strings.addAll(strings1));//strings.addAll(strings1) = true
        System.out.println("Collections.addAll(strings, \"java\", \"hello\", \"learn\") = " + Collections.addAll(strings, "java", "hello", "learn"));//Collections.addAll(strings, "java", "hello", "learn") = true
        System.out.println("strings = " + strings);//strings = [str1, str2, str3, str4, string1, string2, java, hello, learn

        System.out.println("strings.get(1) = " + strings.get(1));//strings.get(1) = str2

        System.out.println("strings.size() = " + strings.size());//strings.size() = 9

        //ArrayList的remove方法可以删除指定内容的元素（传入Object），也可以删除指定索引的元素（传入0或正整数）
        System.out.println("strings.remove(1) = " + strings.remove(1));//strings.remove(1) = str2
        System.out.println("strings.remove(new Integer(1)) = " + strings.remove(new Integer(1)));//strings.remove(new Integer(1)) = false
        System.out.println("strings.remove(\"str1\") = " + strings.remove("str1"));//strings.remove("str1") = true
        System.out.println("strings.removeAll(strings1) = " + strings.removeAll(strings1));//strings.removeAll(strings1) = true
        System.out.println("strings = " + strings);
        //region 便利删除内容，底层调用迭代器
        strings.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("str");
            }
        });
        //endregion

        System.out.println("strings = " + strings);


        strings.clear();//清空集合，没有返回值
        System.out.println("strings.isEmpty() = " + strings.isEmpty());//是否为空
        System.out.println(strings);//直接查看元素内容
        //endregion

        //region 遍历集合的三种方法
        //region Iterator迭代器 遍历集合
        System.out.println("Collections.addAll(strings, \"str\",\"str2\",\"str3\",\"something\",\"something\",\"str4\") = " + Collections.addAll(strings, "str", "str2", "str3", "something","something", "str4"));
        System.out.println("strings = " + strings);
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();//获取当前元素后，将指针指向下一个元素
            if (next.equals("something")) {
                iterator.remove();//通过迭代器删除元素
            }
        }
        System.out.println("strings = " + strings);
        //endregion

        //region 增强for循环
        for (String string : strings) {
            System.out.println(string);
        }
        //endregion

        //region 通过转换为数组遍历
        Object[] objects = strings.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
        //endregion
        //endregion

        //region sort ArrayList的排序
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //endregion
    }
}
