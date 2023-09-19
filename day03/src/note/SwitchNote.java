package note;

import java.util.Scanner;

public class SwitchNote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个0-100之间的分数:");

        int score = scanner.nextInt();

        switch(score / 10) {
            case 10://穿透的巧用
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("E");
        }
    }
}
