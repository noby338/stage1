package note.emun;

public class EnumNote {
    public static void main(String[] args) {
        MyColor red = MyColor.RED;

        System.out.println("red = " + red);
        System.out.println("red.getValue() = " + red.getValue());

        red.setValue("大红色");
        System.out.println("red = " + red);
        System.out.println("red.getValue() = " + red.getValue());
        // 枚举没有无参构造方法，不能实例化(即使手动写了构造方法，也没办法在类的外面调用)
        //new MyColor();
        //MyColor.class.newInstance();
        red.method();//枚举的常量就是方法的调用对象

        //switch语句使用枚举作为参数
        switch (red) {
            case RED:
                System.out.println("选择了RED");
                break;
            case YELLOW:
                System.out.println("选择了YELLOW");
                break;
            default:
                break;
        }
    }
}


