package task;

import java.util.EnumSet;
import java.util.Scanner;

public class Task3 {
    /*
    3.需求: 键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数(不考虑其他字符)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String scanString = scanner.nextLine();
        int lowerCase = 0;
        int upperCase = 0;
        int nums = 0;
        int otherChars = 0;

        for (int i = 0; i < scanString.length(); i++) {
            char thisChar = scanString.charAt(i);
            if (thisChar <= 'Z' && thisChar >= 'A') {
                upperCase++;
            } else if (thisChar <= 'z' && thisChar >= 'a') {
                lowerCase++;
            } else if (thisChar <= '9' && thisChar >= '0') {
                nums++;
            } else {
                otherChars++;
            }
        }

        System.out.println("大写字母" + upperCase+ ",小写字母" + lowerCase + ",数字" + nums + ",其他字符" + otherChars);
    }
}
