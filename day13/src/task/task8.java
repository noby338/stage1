package task;

import java.util.Random;

public class task8 {
    /*
    8.分析以下需求，并用代码实现：
	(1)打印由7，8，9三个数组组成的三位数，要求该三位数中任意两位数字不能相同
	(2)打印格式最后的三位数字以空格分隔，如789 798 879 897 978 987
     */
    public static void main(String[] args) {
        Random random = new Random();
        int s = 3;
        while (s>0) {
            int num = random.nextInt(9 - 7 + 1) + 7;
            s--;
        }

    }
}
