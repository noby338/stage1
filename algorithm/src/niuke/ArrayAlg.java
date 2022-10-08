package niuke;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 【两数之和绝对值最小】给定一个从小到大的有序整数序列(存在正整数和负整数)数组 nums，请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为 最小值，并返回 这个绝对值。每种输入只会对一个答案。但是，数组中同一个元素不能使用两遍。
 * 输入描述:
 * 一个通过空格分割的有序整数序列字符串，最多 1000个整数，且整数数值范围是-65535~65535。
 * 输出描述:
 * 两数之和绝对值最小值。
 * 示例:
 * 输入
 * -3 -1 5 7 11 15
 * 输出
 * 2
 *
 * @author Noby
 * @since 2022/9/28
 */
public class ArrayAlg {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] s = str.split(" ");
        int[] ints = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            ints[i] = Integer.parseInt(s[i]);
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < ints.length; i++) {
            for (int i1 = i + 1; i1 < ints.length; i1++) {
                treeSet.add(Math.abs(ints[i] + ints[i1]));
            }
        }
        System.out.println(treeSet.first());
    }
}
