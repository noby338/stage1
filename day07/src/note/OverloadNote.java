package note;

public class OverloadNote {//方法的重载
    public static void main(String[] args) {
        /*
        方法重载的定义：
        在同一个类里面放定义的几个方法名相同、参数列表不同(类型、个数、顺序)的方法之间构成重载关系，
        重载的目的是为了提供更多方法选项，增强类的功能

        构成方法重载的条件：
        1.相互重载的方法必须定义在一个同一个类
        2.方法名必须相同
        3.参数列表不同(类型、数量、排序)

        注意：方法重载并不在乎方法的返回值类型
         */
        //region


        //endregion
        sum(1,2);
        sum(1.1,2.2);
        sum(1.1,2);
    }

    private static int sum(int num,int num1) {
        return num + num1;
    }

    private static double sum(double num,double num1){
        return num + num1;
    }

    private static double sum(int num,double num1) {
        return num + num1;
    }

    private static double sum(double num,int num1) {
        return num + num1;
    }

}
