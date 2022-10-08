package note.arrray;

import java.util.Random;

public class DyadicArrayNote {//二维数组

    public static void main(String[] args) {
        //region 二维数组的创建
        //方式1
        int[][] array = new int[2][3];//创建一个两行三列的二维数组
        //方式2
        int[][] array1 = new int[][]{
                {11, 12, 13},
                {21, 22, 23}
        };
        //方式3
        int[][] array2 = {
                {11, 12, 13},
                {21, 22, 23}
        };
        //endregion

        //region 数据的获取
        System.out.println("array1[1][0] = " + array1[1][0]);
        //endregion

        //region 二维数组的遍历
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                System.out.print(array1[i][j] + ",");
            }
            System.out.println();
        }
        //endregion
        //region 利用二位数组索引值随机发放不同的扑克牌
        exer();
        //endregion
    }

    private static void exer() {
        String[] color = {"♥", "♠", "♦", "♣"};
        String[] nums = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int[][] poker = new int[4][13];
        Random random = new Random();
        for (int i = 0; i < 10; ) {
            int t1 = random.nextInt(4);
            int t2 = random.nextInt(13);
            if (poker[t1][t2] == 0) {
                poker[t1][t2] = 1;
                i++;
                String resPoker = color[t1] + nums[t2];
                System.out.println(resPoker);
            }
        }
    }
}
