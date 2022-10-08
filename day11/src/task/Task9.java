package task;

import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class Task9 {
    /*
    9.需求：猜数字小游戏，通过Math.random()随机生成一个1-100之间的随机整数，我们就通过键盘录入我们猜的数字，看一看对不对，如果不对，继续猜，直到猜对位置
     */
    public static void main(String[] args) {
        int resultNum = (int) (Math.random() * 99 + 1);
        int times = 5;
        System.out.println("随机数已生成，你一共有" + times + "次机会，你认为这个随机数是多少？");
        Date startTime = new Date();
        boolean isWin = false;
        while (times > 0) {
            Scanner scanner = new Scanner(System.in);
            int guessNum = scanner.nextInt();
            if (guessNum > resultNum) {
                if (times == 1) {
                    break;
                }
                System.out.println("正确答案比这个数小哦！你认为这个随机数是多少?你的剩余次数" + --times);
            } else if (guessNum < resultNum) {
                if (times == 1) {
                    break;
                }
                System.out.println("正确答案比这个数大哦！你认为这个随机数是多少?你的剩余次数" + --times);
            } else {
                isWin = true;
                break;
            }
        }
        if (isWin) {
            System.out.println("恭喜你猜对了！！！");

        } else {
            System.out.println("很遗憾，你输了！正确答案为：" + resultNum);
        }
        Date endTime = new Date();
        int scend = ((int) (endTime.getTime() - startTime.getTime()) / 1000) % 60;
        int minute = ((int) (endTime.getTime() - startTime.getTime()) / 1000) / 60;
        System.out.println("你一共耗时" + minute + "分" + scend + "秒");
    }
}
