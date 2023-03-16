package note;

import java.util.ArrayList;
import java.util.Collections;
/**
 * @Description Collections工具类的使用
 * @Author Noby
 * @Date 2023/3/16 22:00
 */
public class CollectionsNote {
    public static void main(String[] args) {
        //region addAll shuffle sort
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"b","a","c","d","e");//添加多个元素
        System.out.println(list);//[b, a, c]
        Collections.shuffle(list);//随机打乱
        System.out.println(list);//[b, c, a]
        Collections.sort(list);//按照规则排序
        System.out.println(list);//[a, b, c]
        //endregion
    }
}
