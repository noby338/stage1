package note;

public class MathematicalNote {//运算

    public static void main(String[] args) {
        //region 浮点数的运算可能会产生精度损失问题，这是由十进制小数转二进制小数精度损失造成的
        System.out.println(3.2 + 4.4);//7.6000000000000005
        System.out.println(3.2 + 3.3);//6.5
        //region

        //region 逻辑运算符
        boolean b1 = true;
        boolean b2 = false;

        if (b1 == true || (b2 = true) == true) {//第一个执行结果为true后将不会再执行后者
        }
        System.out.println(b1);//true
        System.out.println(b2);//false

        if (b1 == true | (b2 = true) == true) {//第一个执行结果为true后仍会执行后者
        }
        System.out.println(b1);//true
        System.out.println(b2);//true

        System.out.println();

        b1 = false;
        b2 = false;

        if (b1 == true && (b2 = true) == true) {//第一个执行结果为false后将不会再执行后者
        }
        System.out.println(b1);//false
        System.out.println(b2);//false

        if (b1 == true & (b2 = true) == true) {//第一个执行结果为false后仍会执行后者
        }
        System.out.println(b1);//false
        System.out.println(b2);//true
        //endreion

        //region 位运算 更加接近计算机底层，运算速度更快(现代编译器的优化使得使用临时变量temp的方法内存和时间都更优)
        System.out.println("位运算");
        System.out.println(5 >> 2);//5/2^2 = 1
        System.out.println(5 << 2);//5*2^2 = 20

        int x = 7;  //0111
        int y = 9;  //1001
        x ^= y;     //1110
        y ^= x;     //0111
        x ^= y;     //1001
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        int s = 5;
        System.out.println(~s);
        System.out.println(~-6);
        //endregion

        //region 三元运算符
        boolean b;
        b = 5 > 6 ? true : false;
        System.out.println(b);
        //endregion

        //region 赋值运算符具有返回值，它的返回值就是赋的值
        int i = 1;
        int i1;
        i1 = i += 1;
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i1 = 3);
        //endregion

        //region 进制的转换
        //16进制的表示和格式化
        System.out.println(String.format("%x",0x3f));
        //8进制的标识和格式化
        System.out.println(String.format("%o",017));
        //将数字转换为二进制字符串
        System.out.println(Integer.toBinaryString(5));
        //将二进制字符串转换为int
        System.out.println(Integer.parseInt("1111", 2));
        //endregion

        //region 实现数字的倒序
        function(1234);
        //endregion

        //region 不通过第三方变量实现两数据交换  方法1
        function1(10, 20);
        //endregion

        //region 不通过第三方变量实现两数据交换  方法2
        function10(10, 20);
        //endregion

    }

    private static void function10(int num, int num1) {
        num = num + num1;
        num1 = num - num1;
        num = num - num1;
        System.out.println("num+\",\"+num1 = " + num + "," + num1);
    }

    private static void function1(int num, int num1) {
        num ^= num1;
        num1 ^= num;
        num ^= num1;
        System.out.println("num+\",\"+num1 = " + num + "," + num1);
    }

    private static void function(int num) {
        System.out.println(num % 10 * 1000 + num % 100 / 10 * 100 + num % 1000 / 100 * 10 + num / 1000);
        System.out.println(num % 10 * 1000 + num / 10 % 10 * 100 + num / 100 % 10 * 10 + num / 1000);
    }
}
