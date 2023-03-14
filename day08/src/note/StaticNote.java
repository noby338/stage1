package note;

/**
 * 静态属性和静态方法
 */
public class StaticNote {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.r = 10;
        //region 静态属性的值存储在类中，通过类名访问
        Circle.area = 100;//这里的Circle指的不是类，而是该类的字节码文件对象
        //endregion

        //region 静态方法通过类名调用
        Circle.getPI();
        //endregion
    }
}

class Circle {
    static double PI = 3.14;
    int r;
    static double area;

    static void getPI () {
        //region 静态方法不可以访问非静态属性
//        System.out.println(r);
        //endregion

        //region 静态方法可以访问静态属性
        System.out.println(PI);
        //endregion
    }

    void getr () {
        //region 成员方法可以访问非静态属性
        System.out.println(r);
        //endregion

        //region 成员方法可以访问静态属性
        System.out.println(PI);
        //endregion
    }
}
