package note.polymorphic;

public class PolymorphicNote {//多态
    public static void main(String[] args) {
        Animal animal = new Dog();
        //region
        /*
        引用指向哪个对象就会调用该对象的方法，如果子类重写了父类的方法，
        那么调用的就是子类中重写的方法，否则调用的是父类的方法
         */
        System.out.println("animal.name = " + animal.name);//Animal
        System.out.println("new Animal().name = " + new Animal().name);
        System.out.println("new Dog().name = " + new Dog().name);
        System.out.println("animal.bark() = " + animal.bark());//等同于new Dog().bark()
        System.out.println("new Animal().bark() = " + new Animal().bark());
        System.out.println("new Dog().bark() = " + new Dog().bark());
        //endregion

        //region 接口的多态
        Usb usb = new Computer();
        System.out.println("usb.name = " + usb.name);
        System.out.println("usb.read() = " + usb.read());//等同于new Computer().read();
        //endregion


    }
}

class Animal {
    String name = "Animal";
    public String bark() {
        return "Animal叫";
    }
}

class Dog extends Animal{
    String name = "Dog";
    @Override
    public String bark() {
        return "Dog叫";
    }
}

interface Usb {
    String name = "Usb";
    public String read();
}
class Computer implements Usb {
    String name = "Computer";
    @Override
    public String read() {
        return "Computer read";
    }
}


