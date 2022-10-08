package niuke;

import java.util.*;

/**
 * 第一行的输入为矩阵的长宽，矩阵中的1表示障碍，2表示人(有且只有2个)，3表示目的地(可以有多个)
 * 问：在人可以横平竖直的行动下，有几个目的地是两个人都可以同时到达的
 *
 * @author Noby
 * @since 2022/9/28
 */
public class Route {
    public static void main(String[] args) {
        //4 4
        //2 1 0 3
        //0 1 2 1
        //0 3 0 0
        //0 0 0 0

        //4 4
        //2 1 2 3
        //0 1 0 0
        //0 1 0 0
        //0 1 0 0

        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int y = 0;
        while (scanner.hasNextInt()) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            int[][] xy = new int[x][y];
            for (int yi = 0; yi < y; yi++) {
                for (int xi = 0; xi < x; xi++) {
                    xy[xi][yi] = scanner.nextInt();
                }
            }

            int num = 0;
            ArrayList<String> personList = new ArrayList<>();
            ArrayList<String> destList = new ArrayList<>();

            for (int yi = 0; yi < y; yi++) {
                for (int xi = 0; xi < x; xi++) {
                    if (xy[xi][yi] == 2) {
                        personList.add(xi + ":" + yi);
                    }
                    if (xy[xi][yi] == 3) {
                        destList.add(xi + ":" + yi);
                    }
                }
            }

            //region 每个目的地的循环
            for (int i = 0; i < destList.size(); i++) {
                int destX = Integer.parseInt(destList.get(i).split(":")[0]);
                int destY = Integer.parseInt(destList.get(i).split(":")[1]);

                //region 每个人的循环
                //该目的地所有人是否通过的记录
                boolean[] canGet = new boolean[personList.size()];
                for (int i1 = 0; i1 < personList.size(); i1++) {
                    int personX = Integer.parseInt(personList.get(i1).split(":")[0]);
                    int personY = Integer.parseInt(personList.get(i1).split(":")[1]);
                    //当前的路径记录
                    LinkedList<String> nowPath = new LinkedList<>();
                    //错误的点，将不会选择通过
                    HashSet<String> wrongPoint = new HashSet<>();


                    nowPath.add(personX + ":" + personY);

                    System.out.printf("\nperson%d(%d:%d) to dest%d(%d:%d)\n", i1, personX, personY, i, destX, destY);
                    //某人路径路径的循环
                    while (true) {
                        if (personX + 1 < x && xy[personX + 1][personY] != 1 &&
                                !wrongPoint.contains(personX + 1 + ":" + personY) &&
                                !nowPath.contains(personX + 1 + ":" + personY)) {

                            nowPath.add(personX + 1 + ":" + personY);
                            personX++;

                        } else if (personY + 1 < y && xy[personX][personY + 1] != 1 &&
                                !wrongPoint.contains(personX + ":" + (1 + personY)) &&
                                !nowPath.contains(personX + ":" + (1 + personY))) {

                            nowPath.add(personX + ":" + (1 + personY));
                            personY++;

                        } else if (personX - 1 >= 0 && xy[personX - 1][personY] != 1 &&
                                !wrongPoint.contains(personX - 1 + ":" + personY) &&
                                !nowPath.contains(personX - 1 + ":" + personY)) {

                            nowPath.add(personX - 1 + ":" + personY);
                            personX--;

                        } else if (personY - 1 >= 0 && xy[personX][personY - 1] != 1 &&
                                !wrongPoint.contains(personX + ":" + (personY - 1)) &&
                                !nowPath.contains(personX + ":" + (personY - 1))) {

                            nowPath.add(personX + ":" + (personY - 1));
                            personY--;

                        } else if (nowPath.size() == 1) {//跳出循环的条件
                            break;
                        } else {
                            wrongPoint.add(personX + ":" + personY);
                            nowPath.removeLast();
                            continue;
                        }
                        //找到满足的路径
                        if (personX == destX && personY == destY) {
                            canGet[i1] = true;
                            break;
                        }
                    }
                    System.out.println("nowPath = " + nowPath);
                    System.out.println("wrongPoint = " + wrongPoint);
                }
                System.out.println("\nArrays.toString(canGet) = " + Arrays.toString(canGet));
                //endregion 每个人的循环
            }
            //endregion 每个目的地的循环

        }
    }

}
