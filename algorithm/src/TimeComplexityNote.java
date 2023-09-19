/**
 * 时间复杂度计算方式
 * 在这个例子中，我们定义了一个名为sum的方法，该方法接受一个整数n作为参数，并返回1到n的总和。我们使用for循环计算总和，因此该算法的时间复杂度为O(n)。
 * 在main方法中，我们调用sum方法，并使用System.nanoTime()方法来测量方法的执行时间。最后，我们打印出方法的返回结果和执行时间。
 * @author Noby
 * @since 2023/3/17
 */
public class TimeComplexityNote {
    public static void main(String[] args) {
        int n = 10000;
        long startTime = System.nanoTime();
        int result = sum(n);
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        System.out.println("sum(" + n + ") = " + result);
        System.out.println("Time taken: " + time + " nanoseconds");
    }

    static int sum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }
}
