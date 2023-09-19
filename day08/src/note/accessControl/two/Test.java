package note.accessControl.two;

import note.accessControl.one.Father;

public class Test {
    public static void main(String[] args) {
        Father father = new Father();
//        System.out.println(father.name);
        //不同包下只能访问public修饰的属性
        System.out.println(father.age);
//        System.out.println(father.gender);
//        System.out.println(father.money);
    }
}
