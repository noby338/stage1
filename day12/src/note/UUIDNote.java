package note;

import java.util.UUID;

public class UUIDNote {//唯一标识代码，32位随机字符串(不包含-)
    public static void main(String[] args) {
        String string = UUID.randomUUID().toString();
        System.out.println("string = " + string);
    }
}
