/**
 * @Description 空间复杂度的计算方式
 * @Author Noby
 * @Date 2023/3/17
 */
public class SpaceComplexityNote {
    public static void main(String[] args) {
        System.out.println("fibonacci(7) = " + fibonacci(7));
    }

    /**
     * 采用递归计算斐波那契数列
     * 这个算法的空间复杂度为O(n)，因为它需要n个函数调用的栈空间来存储参数和返回地址。如果使用尾递归优化，空间复杂度可以优化为O(1)。
     * 斐波那契数列是指这样一个数列：0、1、1、2、3、5、8、13、21、34、……在数学上，斐波那契数列以递推的方式定义：
     * F(0) = 0
     * F(1) = 1
     * F(n) = F(n-1) + F(n-2) （n ≥ 2，n ∈ N*）
     * @param n
     * @return
     */
    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}


