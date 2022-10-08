package note;

public class CloneNote {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person noby = new Person("noby", new Dog("lucky", new Toy("ball")));
        System.out.println("noby = " + noby);

        Person kace = noby.clone();//深拷贝
        /*
        深拷贝，在拷贝引用类型成员变量时，为引用类型的数据成员另辟了一个独立的内存空间，实现真正内容上的拷贝，而不是地址的拷贝。
         */
        System.out.println("kace = " + kace);

        Person july = noby;//浅拷贝
        /*
        浅拷贝，在拷贝引用类型成员变量时，直接拷贝成员变量的地址值。
         */
        noby.name = "lily";
        System.out.println("july = " + july);
    }
}

class Person implements Cloneable {
    String name;
    Dog dog;
    public Person(String name, Dog dog) {
        this.name = name;
        this.dog = dog;
    }

    @Override
    public Person clone() throws CloneNotSupportedException {
        Person newPerson = (Person)super.clone();
        newPerson.dog = dog.clone();
        return newPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "hashcode=" + this.hashCode() +
                ", name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}

class Dog implements Cloneable{
    String name;
    Toy toy;

    public Dog(String name, Toy toy) {
        this.name = name;
        this.toy = toy;
    }

    @Override
    public Dog clone() throws CloneNotSupportedException {
        Dog newDog = (Dog)super.clone();
        newDog.toy = toy.clone();
        return newDog;
    }
    @Override
    public String toString() {
        return "Dog{" +
                "hashcode=" + this.hashCode() +
                ", name='" + name + '\'' +
                ", toy=" + toy +
                '}';
    }
}

class Toy implements Cloneable{
    String name;

    public Toy(String name) {
        this.name = name;
    }

    @Override
    public Toy clone() throws CloneNotSupportedException {
        return (Toy) super.clone();

    }

    @Override
    public String toString() {
        return "Toy{" +
                "hashcode=" + this.hashCode() +
                ", name='" + name + '\'' +
                '}';
    }
}