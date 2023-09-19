package note;

/**
 * 强制转型
 */
public class CoercionNote {//强制转型
    public static void main(String[] args) {
        //region 父类引用指向子类对象
        Person person = new Student();//发生了向上转型
//        person.stucode;//不能使用子类的属性
//        person.study();//不能使用子类的方法
        //endregion

        //region 向下转型
        Student student = (Student) person;//当该变量本身就引用子类的对象时才可以向下转型
        //endregion
    }
}

class Person {
    String name;
    int age;
    public void show () {
        System.out.println(name + ","+age);
    }
//    public void study() {
//        System.out.println("工作");
//    }
}

class Student extends Person{
    int stucode;
    public void study() {
        System.out.println("学习");
    }

}
