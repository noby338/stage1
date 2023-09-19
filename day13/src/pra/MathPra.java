package pra;

import java.util.Random;

public class MathPra {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int num = random.nextInt(8 - 2 + 1) + 2;
            System.out.println(num);
        }
        for (int i = 0; i < 20; i++) {
            int num2 = (int) (Math.random() * (8 - 2 + 1) + 2);
            System.out.println("num2 = " + num2);
        }

    }
}
