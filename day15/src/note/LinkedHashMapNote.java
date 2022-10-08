package note;

import java.util.LinkedHashMap;

public class LinkedHashMapNote {
    public static void main(String[] args) {
        LinkedHashMap<String, Object> noby = new LinkedHashMap<>();
        noby.put("name","noby");
        noby.put("age",21);
        noby.put("gender","man");

        System.out.println(noby);//{name=noby, age=21, gender=man}
        /*
        LinkedHashMap对存入的顺序进行排序
         */
    }
}
