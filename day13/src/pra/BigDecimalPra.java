package pra;

import java.math.BigDecimal;

public class BigDecimalPra {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("3.14");
        BigDecimal bigDecimal1 = new BigDecimal("2.2");
        System.out.println(bigDecimal);
        System.out.println("bigDecimal.add(bigDecimal1) = " + bigDecimal.add(bigDecimal1));
        System.out.println(bigDecimal.multiply(bigDecimal1).setScale(1, BigDecimal.ROUND_HALF_UP));
        System.out.println("bigDecimal.subtract(bigDecimal1) = " + bigDecimal.subtract(bigDecimal1));
        System.out.println("bigDecimal.divide(bigDecimal1) = " + bigDecimal.divide(bigDecimal1));//未解
    }
}
