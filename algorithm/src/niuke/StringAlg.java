package niuke;

import java.util.Scanner;

/**
 * 字符串最后一个单词的长度
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * <p>
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * @author Noby
 * @since 2022/9/27
 */
public class StringAlg {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;
        if(in.hasNextLine()){
            str = in.nextLine();
        }
        String[] s = str.split(" ");
        System.out.println(s[s.length - 1].length());
    }
}

