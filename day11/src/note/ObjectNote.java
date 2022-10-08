package note;

public class ObjectNote {
    public static void main(String[] args) {
        //region equals
        String str = "java";//存在于常量池中
        String str1 = new String("java");//存在于对象
        System.out.println("str.equals(str1) = " + str.equals(str1));//true，他们的地址值不同，但内容相同
        System.out.println("str == str1 = " + (str == str1));//false
        //endregion

        //region hashcode
        System.out.println("\"Aa\".hashCode() = " + "Aa".hashCode());//2112
        System.out.println("\"BB\".hashCode() = " + "BB".hashCode());//2112
        /*
        他们的哈希值相同，这是由于hash算法本身决定的，它并不能保证一定不存在hash值相同的对象。因此hash相同的对象不代表是同一个对象。
         */
        //endregion
    }
}
