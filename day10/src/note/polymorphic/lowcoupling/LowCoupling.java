package note.polymorphic.lowcoupling;

public class LowCoupling {//低耦合
    public static void main(String[] args) {
        Person xiaoming = new Person("小明",new Cat("chery",true));
        xiaoming.show();
    }
}
