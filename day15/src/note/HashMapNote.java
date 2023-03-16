package note;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * @Description HashMap的基本使用
 * @Author Noby
 * @Date 2023/3/16 23:04
 */
public class HashMapNote {
    public static void main(String[] args) {
        /*
         * HashMap：哈希映射，里面一个数据包个两个非常数据 ： key（键） value（值）
         * 因此称Map是由多个键值对构成的
         *
         * 特点：无序、key不重复
         *
         * 操作Map其实就是操作key
         */

        //region 构造方法
        HashMap<String, Object> noby = new HashMap<>();
        //endregion

        //region 成员方法
        noby.put("name","noby");//添加元素
        noby.put("age",20);//此处传入的是Integer而非int，20将会自动装箱为Integer
        noby.put("isMan",true);
        noby.put("hobby","learn java");

        System.out.println("noby.put(\"age\",21) = " + noby.put("age", 21));//当存在该键时，put方法为修改值，返回的是被覆盖的值

        System.out.println(noby.get("name"));//获取值

        System.out.println(noby.size());//获取键值对长度

        System.out.println("noby.remove(\"hobby\") = " + noby.remove("hobby"));//删除键值对

        System.out.println(noby.containsKey("hobby"));//是否包含该键

        //endregion

        //region 通过keySet集合遍历
        Set<String> keys = noby.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next + " = " + noby.get(next));
        }
        //endregion

        //region 通过entrySet集合遍历
        Set<Map.Entry<String, Object>> entries = noby.entrySet();
        Iterator<Map.Entry<String, Object>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Object> next = iterator1.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }
        //endregion
        /*
         * HashMap数组默认长度是16，加载因子是0.75，数组长度*0.75 = 得到该数组中有几个位置可以用来存储数据
         *
         * 放数据的流程：
         * 	在放数据时会计算key的hash值，用哈希值与 hashCode() ^ h >>> 16，得到一个数字“哈希值”，假设Map
         *  为空（table = null）会先创建一个数组，默认长度为16，然后将扩容触发条件设置为12（16*0.75），接下来
         *  用“哈希值”与15进行按位与得到一个下标，得到数据应该放在数组中的那个位置，如果该位置没有放任何数据，
         *  就创建Node节点直接将新的节点放在这个位置，否则就用当前新数据的“hash”值与该位置数据的“hash”值进行比较，并且
         *  比较当前新的key与该位置的key是否一样，如果一样则替换原来的数据，否则新数据放在原数据的下边形成链表
         *
         *  当链表的长度达到8的时候，就需要将链表转换成红黑树了（提升查询效率）
         *  当红黑树中的节点小于等于6时需要将红黑树转换链表（降低维护的成本）
         *  什么时候需要将链表转换成红黑树：容量必须大于等于64、并且链表的长度大于等于8
         *
         *  扩容时机：当HashMap中的数据个数大于12个时就需要进行扩容了，扩容原来的2倍，触发时机也会变为原来的2倍，
         *  意思就说下一次扩容会在元素个数超过12*2时。
         *  总结：当HashMap中的数据个数达到数组长度*0.75时进行扩容，扩容为原来的两倍
         *  扩容之后：会将之前的数据重新定位放到新数组的各个地方（拆分链表）
         *
         */

    }
}


