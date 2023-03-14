package note;

public class For_While_DoWhileNote {
    public static void main(String[] args) {
        /*
        1、初始化变量。

        for循环当中定义的初始化变量，只有自己才能用；while和do-while循环，初始化变量本来就在外面，所以外面也照样可以使用（定义在循环体里 的局部变量，在栈内运行完释放，并不保存）。

        2、执行次数。

        for循环和while循环是【先判断后执行】，但是do-while循环是【先执行后判断】。

        3、使用的普遍性不同。

        绝大多数情况下，三种循环可以来回转换。但是凡是次数确定、范围确定的情况，使用for循环。
         */
        //region for
        for(int i = 0;i < 10; i++) {
            System.out.printf("这个数值是%d\n",i);
        }
        //endregion

        //region while
        int n = 1;
        while(n <= 10) {
            System.out.println(n * n);
            n++;
        }
        //endregion

        //region do while
        int n1 = 1;
        do {
            System.out.println(n1 * n1);
            n1++;
        } while (n1 <= 10);
        //endregion

    }
}
