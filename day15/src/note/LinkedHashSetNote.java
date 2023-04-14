package note;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet的基本使用
 * @author Noby
 * @since 2023/3/17 0:09
 */
public class LinkedHashSetNote {
    public static void main(String[] args) {
        LinkedHashSet<String> strings = new LinkedHashSet<>();
        strings.add("aaa");
        strings.add("ccc");
        strings.add("ddd");
        strings.add("bbb");
        System.out.println("strings = " + strings);
        //strings = [aaa, ccc, ddd, bbb]
    }
}
