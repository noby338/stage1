package note.polymorphic.lowcoupling;

/**
 * 通过多态实现代码的低耦合
 */
public class LowCoupling {
    public static void main(String[] args) {
        Person xiaoming = new Person("小明",new Cat("chery",true));
        xiaoming.show();
        System.out.println("小明将宠物换成了dog，并不需要修改之前的代码，只需添加dog类");
        xiaoming.pet=new Dog("wangcai", false);
        xiaoming.show();
    }
}
