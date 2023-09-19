package task;

import java.util.Scanner;

public class Task5 {
/*
5.需求：键盘录入一个字符串，如果字符串中包含(TMD),则使用***替换
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String scanString = scanner.nextLine();
        String result = scanString.replace("TMD","***");
        System.out.println(result);
    }
}
