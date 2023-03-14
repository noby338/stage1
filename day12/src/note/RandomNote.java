package note;

import java.util.Random;

/**
 * @author Noby
 * @since 2022/10/3
 */
public class RandomNote {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0;i < 100;i++) {
            //获取[0,10)任意整数
            System.out.println("random.nextInt(10) = " + random.nextInt(10));
        }
        System.out.println("random.nextBoolean() = " + random.nextBoolean());
    }
}
