/**
 * 排列组合算法
 */
public class Permutations {

    public static void main(String[] args) {
        System.out.println("arrangement(6, 2) = " + arrangement(6, 2));
        System.out.println("combination(6, 2) = " + combination(6, 2));
    }

    public static int arrangement(int n, int m) {//组合 A n 取 m
        return factorial(n) / factorial(n - m);
    }

    public static int combination(int n, int m) {//排列, C n 取 m
        return arrangement(n, m) / factorial(m);
    }

    public static int factorial(int num) {//阶乘
        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}


