package note;

import java.util.*;
import java.util.function.Predicate;

public class ArrayListNote {
    public static void main(String[] args) {
        //region 创建
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> strings1 = new ArrayList<>();
        //endregion

        //region 成员方法
        strings.add("str1");//添加
        strings.add("str2");
        strings.add("str3");
        strings.add("str4");
        strings.addAll(strings1);//将其他集合的全部元素加入到该集合
        Collections.addAll(strings, "java", "hello", "learn");//通过Collections集合工具类添加所有元素

        String s = strings.get(1);//获取元素

        int size = strings.size();//获取长度

        strings.remove(1);//删除指定索引的元素(仅当该集合有索引值时可用)
        strings.remove(new Integer(1));//表示删除内容为1的元素
        strings.remove("str1");//删除指定内容
        strings.removeAll(strings1);//将该集合其他集合的全部元素删除
        strings.removeIf(new Predicate<String>() {//遍历删除内容,底层调用的迭代器
            @Override
            public boolean test(String s) {
                return s.contains("str");
            }
        });

        strings.clear();//清空集合
        strings.isEmpty();//是否为空

        System.out.println(strings);//直接查看元素内容
        //endregion

        //region 遍历集合
        //region Iterator迭代器 遍历集合
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();//获取当前元素后，将指针指向下一个元素
            if (next.equals("something")) {
                iterator.remove();//通过迭代器删除元素
            }
        }
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

        //region sort ArrayLi的排序
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //endregion
    }
}
