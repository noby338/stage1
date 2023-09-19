package note;
/*
继承可以提高代码的复用性
一个子类只可以继承一个直接父类(java只支持单继承)
子类的对象属于子类的同时也属于父类

构造方法执行流程：
子类调用构造方法去创建子类的属性前会调用父类的构造方法去创建父类的属性
 */
public class InheritNote {//继承
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Fish fish = new Fish();
        dog.eat();//子类对象可以使用自己类的特有方法
        dog.show();//子类对象可以使用父类的方法
        fish.hoby();
        fish.show();
    }
}

class Animal {
    private String name;
    private int age;
    private String color;

    public void show() {
        System.out.println(name + "," + age + "," + color);
    }

    public Animal() {
    }

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Dog extends Animal {
    private int lengthOfLegs;//腿的长度，狗的特有属性，鱼没有该属性
    public void eat(){
        System.out.println("吃骨头");
    }

    public Dog() {
        super();//该行不写时编译器自动添加
        //表示调用父类的构造方法
    }

    public Dog(String name, int age, String color, int numOfLegs) {
        super(name, age, color);//子类调用构造方法去创建子类的属性前会调用父类的构造方法去创建父类的属性，所以super必须写在第一行
        this.lengthOfLegs = numOfLegs;
    }

    public int getNumOfLegs() {
        return lengthOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.lengthOfLegs = numOfLegs;
    }
}

class Fish extends Animal {
    public String shapeOfScales;//鳞片的形状，鱼的特有属性，狗没有该属性
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