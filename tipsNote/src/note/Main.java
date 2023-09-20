package note;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[num][num];
        for (int i = 0; i < arr.length; i++) {
            String[] str = scanner.nextLine().split(" ");
            for (int i1 = 0; i1 < str.length; i1++) {
                arr[i][i1] = Integer.parseInt(str[i1]);
            }
        }

        ArrayList<Integer> integers = new ArrayList<>();
        int total = 0;
        int line = 0;
        while (integers.size() != num) {
            int min = arr[line][1];
            int xm = 0;
            int ym = 0;
            for (int i1 = 0; i1 < arr[0].length; i1++) {
                if (integers.contains(line)) {
                    continue;
                }
                if ((arr[line][i1] < min && arr[line][i1] > 0)) {
                    ym = i1;
                }
            }
            total += arr[line][ym];
            line = ym;
            integers.add(line);
        }
        System.out.println(total);


    }
}
