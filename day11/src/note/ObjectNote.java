package note;

/**
 * Object对象
 */
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

        //region toString
        System.out.println("new ObjectSon() = " + new ObjectSon());
        //endregion
    }
}

class ObjectSon {//所有的类都集成Object
    //toString方法可以让对象以字符串的格式输出
    @Override
    public String toString() {
        return "重写Object的toString方法，通常用来输出该对象的属性信息";
    }
}
