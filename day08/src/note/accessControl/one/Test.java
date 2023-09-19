package note.accessControl.one;

public class Test {
    public static void main(String[] args) {
        Father father = new Father();
        father.name = "noby";
        father.age = 21;
        father.gender = "man";
        //同一个包下不能访问private修饰的变量
//        father.money = 2000;//'money' has private access in 'note.accessControl.one.Father'
    }
}
