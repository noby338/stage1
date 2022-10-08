package note.accessControl.one;

public class Son extends Father{
    void fun() {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.gender);
        //子类不可以从父类继承父类private修饰的属性
//        System.out.println(this.money);
    }
}
