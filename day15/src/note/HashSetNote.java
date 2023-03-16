package note;

import java.util.Collections;
import java.util.HashSet;

/**
 * @Description HashSet基本使用
 * @Author Noby
 * @Date 2023/3/17 0:08
 */
public class HashSetNote {
    public static void main(String[] args) {
        /*
        底层通过HashMap实现
         */
        //region 创建
        HashSet<String> strings = new HashSet<>();
        //endregion

        //region 相对于list集合有区别的成员方法
        Collections.addAll(strings,"张三","李四","王五","赵六");
        System.out.println(strings.add("张三"));//添加失败，det集合不能存储相同的元素
        System.out.println(strings);//打印出的元素是无序的
        //endregion
    }
}
