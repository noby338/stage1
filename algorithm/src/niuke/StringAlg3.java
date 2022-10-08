package niuke;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 输入一个字符字符串，把其中的两个字符交换一次，使得得到的字符串为最小自然顺序
 * @author Noby
 * @since 2022/9/28
 */
public class StringAlg3 {
    public static void main(String[] args) {
        // bcdefa acdefb
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        TreeSet<String> strings = new TreeSet<>();
        strings.add(str);

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int i1 = i + 1; i1 < chars.length; i1++) {
                chars = str.toCharArray();
                char temp = chars[i];
                chars[i] = chars[i1];
                chars[i1] = temp;
                strings.add(new String(chars));
            }
        }
        System.out.println(strings.first());
    }
}
