package leetcode;

import java.util.LinkedList;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2：
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Noby
 * @since 2022/9/30
 */
public class ArrayAlg {
    public static void main(String[] args) {
        int[][] ints =
//                {
//                        {1, 1, 1},
//                        {1, 0, 1},
//                        {1, 1, 1}
//                };
        {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        new Solution().setZeroes(ints);
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        LinkedList<Integer> xy = new LinkedList<>();
        int height = matrix.length;
        int width = matrix[0].length;
        for (int i = 0; i < height; i++) {
            for (int i1 = 0; i1 < width; i1++) {
                if (matrix[i][i1] == 0) {
                    xy.add(i);
                    xy.add(i1);
                }
            }
        }
        int num = xy.size() / 2;
//        int[] empty = new int[width];
        for (int i0 = 0; i0 < num; i0++) {
            Integer x = xy.get(i0*2);
            Integer y = xy.get(i0*2+1);
            for (int i = 0; i < width; i++) {
                matrix[x][i] = 0;
            }
//            matrix[x] = empty;
            for (int i = 0; i < height; i++) {
                matrix[i][y] = 0;
            }
        }
//        for (int i = 0; i < matrix.length; i++) {
//            for (int i1 = 0; i1 < matrix[i].length; i1++) {
//                System.out.print(matrix[i][i1]+ " ");
//            }
//            System.out.println();
//        }

    }
}



