import java.util.Random;

public class Minesweeper {//扫雷游戏
    public static void main(String[] args) {
        int lineNums = 9;//9*9的格子
        int minesNums = 30;//生成30颗雷
        char[][] coordinate = new char[lineNums][lineNums];
        Random random = new Random();
        //region 放入地雷
        for (int i = 0;i < minesNums;) {
            int x = random.nextInt(lineNums);
            int y = random.nextInt(lineNums);
            if (coordinate[x][y] != '*') {
                coordinate[x][y] = '*';
                i ++;
            }
        }
        //endregion

        //region 显示非地雷点的地雷数目
        for (int i = 0; i < coordinate.length; i++) {
            for (int j = 0; j < coordinate[0].length; j++) {
                int num = 0;//此位置周围的地雷数目
                if (coordinate[i][j] != '*') {
                    boolean xlbound = i - 1 >= 0;
                    boolean xrbound = i + 1 < lineNums;
                    boolean ylbound = j - 1 >= 0;
                    boolean yrbound = j + 1 < lineNums;
                    if (xlbound && ylbound && coordinate[i - 1][j - 1] == '*') {
                        num++;
                    }
                    if (xlbound && coordinate[i - 1][j] == '*') {
                        num++;
                    }
                    if (xlbound && yrbound && coordinate[i - 1][j + 1] == '*') {
                        num++;
                    }
                    if (ylbound && coordinate[i][j - 1] == '*') {
                        num++;
                    }
                    if (yrbound && coordinate[i][j + 1] == '*') {
                        num++;
                    }
                    if (xrbound && ylbound && coordinate[i + 1][j - 1] == '*') {
                        num++;
                    }
                    if (xrbound && coordinate[i + 1][j] == '*') {
                        num++;
                    }
                    if (xrbound && yrbound && coordinate[i + 1][j + 1] == '*') {
                        num++;
                    }

                    coordinate[i][j] = (char)(num + '0');
                }
            }
        }
        //endregion

        //region 遍历显示
        for (char[] chars : coordinate) {
            for (int j = 0; j < coordinate[0].length; j++) {
                System.out.printf("%c  ", chars[j]);
            }
            System.out.println();
        }
        //endregion
    }
}
