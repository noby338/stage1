package pra;

import java.io.UnsupportedEncodingException;

public class StringPra {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = new String(new byte[]{97,98,65,99,100,101} , 1,3);
        System.out.println(str);
        String str1 = new String(new byte[]{'a','b','c','d','e'},"utf-8");
        System.out.println(str1);
        byte[] bytes = "java".getBytes();
        char[] chars = "java".toCharArray();
        System.out.println("java".substring(1));
        System.out.println("java".substring(1, 4));
        System.out.println("ja".concat("va"));
        System.out.println("\"HelloWorld\".contains(\"oW\") = " + "HelloWorld".contains("oW"));
        System.out.println("\"HelloWorld\".indexOf(\"rl\") = " + "HelloWorld".indexOf("rl"));
        System.out.println("\"HelloWorld\".indexOf('l') = " + "HelloWorld".indexOf('l'));
        System.out.println("\"HelloWorld\".indexOf('0') = " + "HelloWorld".indexOf('0'));
        System.out.println("\"HelloWorld\".lastIndexOf('l') = " + "HelloWorld".lastIndexOf('l'));
        System.out.println("\"compareTo\".compareTo(\"java\") = " + "compareTo".compareTo("compareTo"));
        String[] ps = "split".split("p");
        System.out.println(ps[1]);
        System.out.println(new StringBuffer("java").reverse().toString());
        System.out.println("\"java\".length() = " + "java".length());
        System.out.println("\"helloworld\".toUpperCase() = " + "helloworld".toUpperCase());
        System.out.println("\"Hello\".toLowerCase() = " + "Hello".toLowerCase());
        System.out.println("\"java\".startsWith(\"ja\") = " + "java".startsWith("ja"));
        System.out.println("\"java\".endsWith(\"va\") = " + "java".endsWith("va"));
        System.out.println("java".replace('a', ' '));
        String[] ls = "HelloWorld".split("l");
        StringBuilder helloWorld = new StringBuilder("HelloWorld");
        for (int i = 0; i < helloWorld.length(); i++) {
            if (helloWorld.charAt(i) == 'l') {
                helloWorld.deleteCharAt(i);
                i--;
            }
        }
        System.out.println(helloWorld.toString());
        char[] chars1 = "HelloWorld".toCharArray();
        int length = chars1.length;
        for (int i = 0; i < length ; i++) {
            if (chars1[i] == 'l') {
                length --;
                for (int j = i; j < length; j++) {
                    chars1[j] = chars1[j + 1];
                }
                i--;
            }
        }
        System.out.println(new String(chars1,0,length));


    }
}
