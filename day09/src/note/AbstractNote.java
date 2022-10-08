package note;
public class AbstractNote {//抽象方法和抽象类
    public static void main(String[] args) {
        //region
        /*
        抽象类不能实例化(不能创建对象)，必须由其实现类(子类)实例化
        为什么不能实例化？
        没有一个对象叫动物，他没有具体的属性，(动物几只脚、有没有毛)
         */
//        new Animal();
        //endregion
    }
}

abstract class Animal {
    //region 抽象方法
    /*
    当某个父类某个方法根据子类的不同而有不同的实现，且父类不能实现该方法时，此方法应该定义为抽象方法
    方法后的{}即为该方法的实现
     */
    public abstract void eat();
    //endregion

    public void show() {//抽象类可以有非抽象方法
        System.out.println("我属于动物");
    }

}

class Dog extends Animal{

    @Override
    public void eat() {
        System.out.println("吃骨头");
    }
}
