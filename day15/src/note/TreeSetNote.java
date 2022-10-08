package note;

import java.util.Collections;
import java.util.TreeSet;

public class TreeSetNote {
    public static void main(String[] args) {
        /*
         * TreeSet基于红黑树实现的 TreeMap（平衡二叉树-排序二叉树-红黑树）
         * TreeSet里面的数据是有序的
         */
        //region 构造
        TreeSet<String> strings = new TreeSet<>();
        //endregion

        //region 相对于HashSet的不同
        Collections.addAll(strings,"java","hello","world");
        System.out.println("strings = " + strings);//相对于HashSet，该集合有序(按照字典排序，而非存入顺序)
        //endregion



    }
}
