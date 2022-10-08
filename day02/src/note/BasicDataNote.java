package note;

public class BasicDataNote {
    public static void main(String[] args) {
        //基本数据类型在方法中声明都不具有默认值，作为类的属性时有默认值；
        //类(String属于类)、数组、接口为引用数据类型
        byte b;
        char c;
        short s;//不常用
        int i;
        long l;
        float f;//不常用
        double d;
        boolean flag;

        char ch = 'a';
//        float f = 23.1;//将报错，float型数据类型后应加上f
//        long  longint = 3000000000;//将报错，long型数据类型后应加上l


        System.out.println(ch == 97);//true
        System.out.println(ch == 'a');//true
        System.out.println(ch == 0x61);//true

        System.out.println("ch = " + ch);//char类型的调用默认为字符
        System.out.println("(int)ch = " + (int) ch);//可进行强转
    }
}
