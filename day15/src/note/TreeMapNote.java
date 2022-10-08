package note;

import java.util.HashMap;
import java.util.TreeMap;

public class TreeMapNote {
    public static void main(String[] args) {
        //region 构造
        TreeMap<String, Object> kace = new TreeMap<>();
        //endregion

        //region 成员方法
        kace.put("ccc",22);
        kace.put("aaa","kace");
        kace.put("bbb","man");

        /*
        TreeMap集合有序:并不是对存入的顺序进行排序，而是通过一定的规则排序
        LInkedHashMap集合有序：对存入的顺序进行排序
         */
        //endregion

        System.out.println(kace);//{aaa=kace, bbb=man, ccc=22}
    }
}
