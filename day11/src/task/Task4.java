package task;


import java.util.Scanner;

public class Task4 {
    /*
    4.需求：以字符串的形式从键盘接收一个手机号，将中间四位号码屏蔽，最终效果为：156****1234
     */
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入电话号码：");
//        String scanString = scanner.nextLine();
//        String result = scanString.substring(0,3) + "****" + scanString.substring(7, scanString.length());
//        System.out.println(result);
//        method1();
        method2();
    }

    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入电话号码");
        String scanString = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(scanString);

        stringBuilder.delete(3, 7);
        stringBuilder.insert(3,"****");
        System.out.println(stringBuilder);
    }

    private static void method1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入电话号码：(方法1)");
        String scanString = scanner.nextLine();
        char[] chars = scanString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i >= 3 && i < 7) {
                chars[i] = '*';
            }
        }
        String result = new String(chars);
        System.out.println(result);
    }
}
