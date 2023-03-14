package note.polymorphic;

/**
 * 多态
 */
public class PolymorphicNote {
    public static void main(String[] args) {
        Animal animal = new Dog();
        //region
        /*
        引用指向哪个对象就会调用该对象的方法，如果子类重写了父类的方法，
        那么调用的就是子类中重写的方法，否则调用的是父类的方法
         */
        System.out.println("animal.name = " + animal.name);//Animal
        System.out.println("new Animal().name = " + new Animal().name);//Animal
        System.out.println("new Dog().name = " + new Dog().name);//Dog
        System.out.println("animal.bark() = " + animal.bark());//Dog叫，等同于new Dog().bark()
        System.out.println("new Animal().bark() = " + new Animal().bark());//Animal叫
        System.out.println("new Dog().bark() = " + new Dog().bark());//Dog叫
        //endregion

        //region 接口的多态
        Usb usb = new Computer();
        System.out.println("usb.read() = " + usb.read());//Computer read，等同于new Computer().read();
        //endregion

    }
}

class Animal {
    String name = "Animal";
    String bark() {
        return "Animal叫";
    }
}

class Dog extends Animal{
    String name = "Dog";
    @Override
    String bark() {
        return "Dog叫";
    }
}

interface Usb {
    String read();
}

class Computer implements Usb {
    @Override
    public String read() {
        return "Computer read";
    }
}


