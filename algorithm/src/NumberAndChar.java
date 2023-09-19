import java.util.Random;

/**
 * 随机生成字符和数字
 *
 * @author Noby
 * @since 2023/5/2 22:52
 */
public class NumberAndChar {
    public static void main(String[] args) {
        String symbols2 = "0123456789!@#$%^&*()_+-=[]{};:,.<>?";
        String symbols1 = "0123456789!@#$%^&*()_+-=[]{};:,.<>?";
        String symbols = "!@#$%^&*()_+-=[]{};:,.<>?";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 300; // 随机字符的长度
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(symbols.length());
            char c = symbols.charAt(index);
            sb.append(c);
        }

        System.out.println("随机生成的字符：" + sb);
    }


}
