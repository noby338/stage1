package task;


import java.util.Scanner;

public class Task12 {
    /*
    12.分析以下需求,并用代码实现
	1.键盘录入一个字符串
	2.将该字符串变成字符数组(不能使用toCharArray()方法)
	3.将字符数组中的所有大写字母变成小写字母(不能使用toLowerCase()方法)
	4.如果第一位和最后一位的内容不相同,则交换
	5.将字符数组中索引为偶数的元素变成'~'
	6.打印数组元素的内容
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String scanStr = scanner.nextLine();
        char[] chars = new char[scanStr.length()];
        if (chars[0] != chars[chars.length - 1]) {
            chars[0] ^= chars[chars.length - 1];
            chars[chars.length - 1] ^= chars[0];
            chars[0] ^= chars[chars.length - 1];
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = scanStr.charAt(i);
            if(i % 2 == 0) {
                chars[i] = '~';
            }
            if (chars[i] <= 'Z' &&chars[i] >= 'A'){
                chars[i] = (char) (chars[i] + 32);
            }
        }

        String string = new String(chars);
        System.out.println(string);
    }
}