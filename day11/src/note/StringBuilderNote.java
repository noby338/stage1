package note;
/**
 * StringBuilder
 * StringBuilder相比较StringBuffer线程不安全
 */
public class StringBuilderNote {
    public static void main(String[] args) {
        //region 构造方法
        StringBuilder stringBuilder = new StringBuilder();//初始容量为16，当容量不够是扩容到原来的2倍+2
        StringBuilder stringBuilder1 = new StringBuilder(new String("str"));//初始容量为16+str.length()
        StringBuilder stringBuilder2 = new StringBuilder(5);//定义容量为指定值

        System.out.println("stringBuilder.capacity() = " + stringBuilder.capacity());
        System.out.println("stringBuilder1.capacity() = " + stringBuilder1.capacity());
        System.out.println("stringBuilder2.capacity() = " + stringBuilder2.capacity());
        //endregion

        //region 成员方法
        stringBuilder.append(1).append("abc").append('a').append(9.8).append(new Object());//字符的添加，可添加任意数据类型，以字符串存储，返回的为一个StringBuilder，   链式编程
        System.out.println("stringBuilder.capacity() = " + stringBuilder.capacity());//获取可变字符串的容量
        System.out.println("stringBuilder.charAt(2) = " + stringBuilder.charAt(2));//获取指定索引的值
        System.out.println("stringBuilder = " + stringBuilder);
        stringBuilder.delete(2,5);//删除指定区间 5表示索引
        stringBuilder.insert(2,"abc");//指定索引插入字符串
        System.out.println("stringBuilder = "  + stringBuilder);
        System.out.println("stringBuilder.length() = " + stringBuilder.length());
        System.out.println("stringBuilder.substring(3) = " + stringBuilder.substring(3));//字符串截取
        System.out.println("stringBuilder.substring(4,6) = " + stringBuilder.substring(4, 6));
        StringBuilder reverse = stringBuilder.reverse();//reverse()翻转字符串缓冲区
        System.out.println("reverse.toString() = " + reverse.toString());//toString将字符串缓冲区转换为字符串
        //endregion

        //region 利用StringBuilder删除字符串中的指定字符的方法
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == 'a') {
                stringBuilder.deleteCharAt(i--);
            }
        }
        //endregion


    }
}
