package note;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsNote {//collection工具类
    public static void main(String[] args) {
        //region addAll shuffle sort
        ArrayList<String> lis = new ArrayList<>();
        Collections.addAll(lis,"b","a","c","d","e");//添加多个元素
        System.out.println(lis);//[b, a, c]
        Collections.shuffle(lis);//随机打乱
        System.out.println(lis);//[b, c, a]
        Collections.sort(lis);//按照规则排序
        System.out.println(lis);//[a, b, c]
        //endregion
    }
}
