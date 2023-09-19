package note;

public class ConversionNote {

    public static void main(String[] args) {
        byte b = 1;
        byte b1;
        byte b2 = 3;

        int i = 2;
        int i1;
        final int i2 = 100;
        final int i3 = 27;

        i1 = b + i;//进行了自动转换(隐式类型转换)，小变大。byte、short、char‐‐>int‐‐>long‐‐>float‐‐>double
        System.out.println(i1);//3

        b1 = (byte) (b + i);//(b+i)结果为int，为了放入b1中，进行了强制类型转换(显式类型转换)，将int强制变为byte，可能造成精度损失
        System.out.println(b1);//3

        b2 += 1;// += 是一个运算符，只运算一次，并带有强制转换的特点，也就是说 s += 1 就是 s = (byte)(s + 1)
        System.out.println(b2);//4

        //所有的byte、short、char运算前都会转换为int
        //b1 = b+b2;//将报错

        //数字为常数，当计算结果在被赋值的变量范围中时，将不会进行变量的自动转换
        b1 = 1 + 2;//不会报错

        //以下代码将不会报错
        b1 = i2 + i3;//被final修饰的int为常量，当右侧表达式为常量，由于右侧没有超过左侧的范围，编译器自动强制转换（生成的字节码文件会自动补充（byte）），这称为编译器的常量优化
        System.out.println(b1);

    }
}

