package note;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String的常用API
 */
public class StringNote {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //region 字符串的构造
        String str = "abc";

        String str1 = new String("abc1");

        String str2 = new String(new byte[]{'a', 'b', 99, '2'});

        String str3 = new String(new byte[]{'a', 'b', 99, '3'}, "gbk");

        String str4 = new String(new byte[]{'a', 'b', 99, '4', '5', '6', '7'}, 1, 4);//4为长度

        String str5 = new String(new char[]{'a', 'b', 99, '4'});

        String str6 = new String(new char[]{'a', 'b', 99, '4', '5', '6', '7'}, 1, 4);

        System.out.println("str = " + str);//str = abc
        System.out.println("str1 = " + str1);//str1 = abc1
        System.out.println("str2 = " + str2);//str2 = abc2
        System.out.println("str3 = " + str3);//str3 = abc3
        System.out.println("str4 = " + str4);//str4 = bc45
        System.out.println("str5 = " + str5);//str5 = abc4
        System.out.println("str6 = " + str6);//str6 = bc45
        //endregion


        //region String.format 方法
        //8表示占位数，负数标空处向左对齐
        System.out.println(String.format("这个double数的值是：%-8.2f和%-,3.1f的值", 3.1415926, 31415.926));//这个double数的值是：3.14    和31,415.9的值
        //"，"表示输出的数值用"，"隔开，13表示向右对齐，占位数为13 0表示空位补0
        System.out.println(String.format("int数值是：%0,13d", 1234567));//int数值是：00001,234,567
        //endregion

        //region 字符串的方法
        System.out.println("字符串的方法");
        System.out.println("str.charAt(2) = " + str.charAt(2));//str.charAt(2) = c
        System.out.println("str.compareTo(str1) = " + str.compareTo("abc11"));//str.compareTo(str1) = -2
        /*
        返回第一个不相同字符的ASCII码值之差，如果是正数表示s1大于s2，如果是0表示s1和s2一样
        如果不存第一个不相同的字符，且两字符串的长度不同，则返回s1的长度-s2的长度
         */
        System.out.println("str.concat(\"concat\") = " + str.concat("concat"));//str.concat("concat") = abcconcat
        System.out.println("\"contains\".contains(\"ta\") = " + "contains".contains("ta"));//"contains".contains("ta") = true
        System.out.println("\"startWith\".startsWith(\"star\") = " + "startWith".startsWith("star"));//"startWith".startsWith("star") = true
        System.out.println("\"endsWith\".endsWith(\"with\") = " + "endsWith".endsWith("with"));//"endsWith".endsWith("with") = false
        System.out.println("\"abc\".equals(\"str\") = " + "abc".equals("ABC"));//"abc".equals("str") = false
        System.out.println("\"abc\".equalsIgnoreCase(\"ABC\") = " + "abc".equalsIgnoreCase("ABC"));//"abc".equalsIgnoreCase("ABC") = true
        byte[] bytes = "getBytes".getBytes();
        byte[] bytes1 = "getBytes".getBytes("utf-8");
        char[] chars = "toCharArray".toCharArray();
        System.out.println("Arrays.toString(bytes) = " + Arrays.toString(bytes));//Arrays.toString(bytes) = [103, 101, 116, 66, 121, 116, 101, 115]
        System.out.println("Arrays.toString(bytes1) = " + Arrays.toString(bytes1));//Arrays.toString(bytes1) = [103, 101, 116, 66, 121, 116, 101, 115]
        System.out.println("chars = " + Arrays.toString(chars));//chars = [t, o, C, h, a, r, A, r, r, a, y]
        System.out.println("\"indexOf\".indexOf('d') = " + "indexOf".indexOf('d'));//"indexOf".indexOf('d') = 2
        System.out.println("\"indexOf\".indexOf(\"ex\") = " + "indexOf".indexOf("ex"));//"indexOf".indexOf("ex") = 3
        System.out.println("\"lastIndexOfOf\".lastIndexOf(\"Of\") = " + "lastIndexOfOf".lastIndexOf("Of"));//"lastIndexOfOf".lastIndexOf("Of") = 11
        System.out.println("\"length\".length() = " + "length".length());//"length".length() = 6
        System.out.println("\"substring\".substring(2) = " + "substring".substring(2));//"substring".substring(2) = bstring
        //第二个数字表示索引而非长度
        System.out.println("\"substring\".substring(3,6) = " + "substring".substring(3, 6));//"substring".substring(3,6) = str
        System.out.println("\"toLowerCase\".toLowerCase() = " + "toLowerCase".toLowerCase());//"toLowerCase".toLowerCase() = tolowercase
        System.out.println("\"toUpperCase\".toUpperCase() = " + "toUpperCase".toUpperCase());//"toUpperCase".toUpperCase() = TOUPPERCASE
        System.out.println("\" trim \".trim() = " + " trim ".trim());//" trim ".trim() = trim
        System.out.println("\"java\".replace('j','s') = " + "java".replace('j', 's'));//"java".replace('j','s') = sava
        System.out.println("\"java\".replace(\"ja\",\"ab\") = " + "java".replace("ja", "ab"));//"java".replace("ja","ab") = abva
        System.out.println("Arrays.toString(\"H,ell,o\".split(\",\")) = " + Arrays.toString("H,ell,o".split(",")));//Arrays.toString("H,ell,o".split(",")) = [H, ell, o]

        /*
        new String()的创建，第二个参数为数组的长度
        Arrays.copyOfRange()的使用，第二个参数为数组的索引，其长度可以大于原数组
        substring()的使用，第二个参数为数组的索引
        StringBuilder.delete()第二个参数为索引

        indexOf(),LastIndexOf()的使用，可以传入字符和字符串
        replace()的使用，可以传入字符和字符串
        contains()的使用，只可以传入字符串
         */
        //endregion


        //region Sting面试题
        System.out.println("Sting面试题");
        String s = "abcd";//常量池中不存在abcd，在常量池中创建abcd
        //java常量优化机制：给一个变量赋值，如果等于号的右边是常量的表达式并且没有一个变量，那么就会在编译阶段计算该表达式的结果
        String s2 = "a" + "b" + "c" + "d";//常量池中存在abcd，编译期java常量优化机制计算的结果为该值，直接引用该值
        String s3 = "ab" + "cd";
        String s4 = new String("abcd");//创建了String对象，该对象的值引用了常量池中的abcd，如果没有abcd，则同时常量池中创建abcd对象和堆中String对象两个对象
        String temp = "ab";
        String s5 = temp + "cd";//当涉非常量的字符串的拼接时，通过StringBuilder进行计算，将计算的结果转换为新的String
        String s6 = getAb() + "cd";
        System.out.println(s == s2);//true
        System.out.println(s == s3);//true
        System.out.println(s == s4);//false
        System.out.println(s == s5);//false
        System.out.println(s == s6);//false
        System.out.println(s5 == s6);//false

        String string = "st";
        String string2 = "ri";
        String string3 = "ng";
        String string4 = "te";
        String string5 = "st";
        String stringTest = string + string2 + string3 + string4 + string5;
        //多次字符串相加底层调用StingBuilder，可反编译查看源码(实际查看源码没发现为StringBuilder)
        System.out.println("stringTest = " + stringTest);
        //endregion
    }

    private static String getAb() {
        return "ab";
    }
}
