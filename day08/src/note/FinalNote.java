package note;

public class FinalNote {
    public static void main(String[] args) {
        //region final修饰基本数据类型
        final int NUM;//final修饰的变量一般为大写(该变量变为常量)
        NUM = 5;//final常量只有第一次赋值才会成功
//        NUM = 2;//final常量的初值不能被改变
        //endregion

        //region final修饰引用数据类型
        final String[] NAMES = new String[3];
//        NAMES = new String[4];//final修饰的引用数据类型其引用不可更改
        NAMES[0] = "noby";
        NAMES[0] = "kace";//引用里面的数据可以更改
        //endregion
        Teacher t = new Teacher();
        t.say();//仍然可以使用父类的方法(可以继承，但不能重写)
    }
}

class Person {
    private final String NAME = "noby";//final修饰的成员变量必须赋初值
    public final void say() {
        System.out.println("说....");
    }

}
final class Teacher extends Person {
    //1. final修饰的方法不能被重写，但此方法仍然被继承
    /*@Override
    public void say() {
        System.out.println("老师在一本正经的说...");
    }*/
}

//class EnglishTeacher extends Teacher {}//final修饰的类不能被继承


