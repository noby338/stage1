package note;

public class RecursionNote {//递归算法

    public static void main(String[] args) {
        //region 算出十进制对应的二进制
        binary(5);
        //endregion

        //region 汉诺盘
        System.out.println();
        hanoi("A","B","C",3);
        //endregion
    }

    private static void binary(int n) {
        if(n == 1 || n == 0){
            System.out.print(n);
            // 程序没有必要继续向下执行了
            return;   // 让当前函数提前结束
        }
        // 执行到这里说明n不是1或者0
        // 除2取余
        int shang = n / 2;

        // 函数调用自己计算商的二进制
        binary(shang);

        int yu = n % 2;
        System.out.print(yu);
    }

    public static void hanoi(String src,String temp,String dest,int n){
        if(n == 1){
            // 只有一个盘子，从src移动到dest
            System.out.println(src +" -> " + dest);
            //结束当前程序
            return;
        }
        //第一步将上面n-1个从
        hanoi(src, dest, temp, n - 1);
        //第二步将最后一个从A移动到C
        hanoi(src, temp, dest, 1);
        //第三步从B移动到C，A作为中转
        hanoi(temp, src, dest, n - 1);
    }
}
