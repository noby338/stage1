package note;

import java.util.Scanner;

/**
 * 测试
 *
 * @author Noby
 * @since 2023/4/16 22:26
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String s = str.split(" ")[0];
        String s2 = str.split(" ")[1];
        System.out.println("s = " + s);
        System.out.println("s2 = " + s2);

        char[] chars = s.toCharArray();
        char[] chars1 = s2.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            int num2 = 0;
            for (int i1 = 0; i1 < chars1.length; i1++) {
                try {
                    if (chars[i+i1] == chars[i1]) {
                        num2++;
                    }
                } catch (Exception e) {
                }
                if (num2 == chars1.length) {
                    num ++;
                }
            }
            num ++;
        }
        System.out.println(num);
    }
}
