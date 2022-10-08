package note;

public class InheritNote {//继承(覆盖重写)
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Fish fish = new Fish();
        dog.eat();//子类对象可以使用自己类的特有方法
        dog.bark();//子类对象使用由重写父类bark()方法后得到的子类bark()方法
        fish.hoby();
        fish.bark();
    }
}

class Animal {
    private String name;
    private int age;
    private String color;

    public void bark() {
        System.out.println("宠物叫");
    }

    public Object getObject () {
        return new Object();
    }

    public Animal() {
    }

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

}

class Dog extends Animal {
    private int lengthOfLegs;//腿的长度，狗的特有属性，鱼没有该属性
    public void eat(){
        System.out.println("吃骨头");
    }

    //region 方法的覆盖重写 如果父类的方法不能满足子类需求时，子类可以对该方法进行覆盖重写，重新实现该方法
    @Override//@Override：写在方法前面，用来检测是不是有效的正确覆盖重写。这个注解就算不写，只要满足要求，也是正确的方法覆盖重写。
    public void bark() {
        System.out.println("汪汪汪");
    }
    //endregion

    @Override
    public String getObject() {
        return new String("");
    }

    public Dog() {
        super();//该行不写时编译器自动添加
        //表示调用父类的构造方法
    }

    public Dog(String name, int age, String color, int numOfLegs) {
        super(name, age, color);//子类调用构造方法去创建子类的属性前会调用父类的构造方法去创建父类的属性，所以super必须写在第一行
        this.lengthOfLegs = numOfLegs;
    }


}

class Fish extends Animal {
    public String shapeOfScales;//鳞片的形状，鱼的特有属性，狗没有该属性

    @Override
    public void bark() {
        System.out.println("biubiubiu");
    }

    public void hoby(){
        System.out.println("吐泡泡");
    }

    public Fish() {
        super();
    }

    public Fish(String name, int age, String color, String shapeOfScales) {
        super(name, age, color);
        this.shapeOfScales = shapeOfScales;
    }


}
