package note.accessControl.two;

import note.accessControl.one.Father;

public class Son extends Father {
    void fun() {
        String gender = super.gender;
        String gender1 = this.gender;
        String gender2 = new Son().gender;
//        String gender3 = new Father().gender;//报错
        //在子类中，子类实例可以访问其从父类继承而来的 protected 方法，而不能访问父类实例的protected方法
    }
}
