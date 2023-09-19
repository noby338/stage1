package task;

import java.util.Scanner;

public class Task7 {
/*
7.需求：键盘接收一个字符串，程序判断出该字符串是否是对称字符串，并在控制台打印是或不是
            对称字符串：123321,111
            非对称字符串：123123
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字");
        String scanString = scanner.nextLine();
        boolean flag = true;
        for (int i = 0; i < scanString.length() / 2; i++) {
            if (scanString.charAt(i) != scanString.charAt(scanString.length() - i - 1)) {
                flag = false;
                break;
            }
        }
        System.out.println("这是一个回文数？" + flag);
    }
}
