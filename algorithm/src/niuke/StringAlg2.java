package niuke;

import java.util.*;

/**
 * @author Noby
 * @since 2022/9/27
 */
public class StringAlg2 {
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap();
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine().trim();
        String c = in.nextLine().toLowerCase();
        char[] chars = str.toLowerCase().toCharArray();
        for (char aChar : chars) {
            if (hashMap.get(aChar) == null) {
                hashMap.put(aChar, 1);
            } else {
                hashMap.put(aChar, hashMap.get(aChar) + 1);
            }
        }
        System.out.println(hashMap.get(c.charAt(0)) == null ? 0 : hashMap.get(c.charAt(
                0)));
    }
}
