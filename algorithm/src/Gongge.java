import java.util.Scanner;

public class Gongge {//该方法可以创建一个奇数行列的宫格，宫格的每一行、列及对角线相加都是相同的数

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个奇数行数(列数)：");
        int rows = scanner.nextInt();
        int[][] nums = new int[rows][rows];
        int x = 0;
        int y = rows / 2;

        for (int index = 1; index <= rows * rows; index++) {
            nums[x--][y++] = index;
            y %= rows;
            x = (x % rows + rows) % rows;
            if (nums[x][y] != 0) {
                x += 2;
                y -= 1;
            }
            x %= rows;
            y = (y % rows + rows) % rows;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.printf("%-4d", nums[i][j]);
            }
            System.out.println();
        }
    }
}
