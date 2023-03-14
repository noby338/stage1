package pra;


/**
 * @author Noby
 * @since 2023/3/11
 */
public class ClonePra {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person noby = new Person("noby", new Dog("lady", new Toy("boat")));
        System.out.println("noby = " + noby);
        Person kace = noby.clone();
        System.out.println("kace = " + kace);
        kace.setName("kacee");
        System.out.println("noby = " + noby);
        System.out.println("kace = " + kace);

    }
}

class Person implements Cloneable{
    private String name;
    private Dog dog;

    public Person() {
    }

    public Person(String name, Dog dog) {
        this.name = name;
        this.dog = dog;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person thisPerson = (Person)super.clone();
        thisPerson.dog = dog.clone();
        return thisPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}

class Dog  implements Cloneable{
    private String name;
    private Toy toy;

    public Dog() {
    }

    public Dog(String name, Toy toy) {
        this.name = name;
        this.toy = toy;
    }

    @Override
    protected Dog clone() throws CloneNotSupportedException {
        Dog thisDog = (Dog)super.clone();
        thisDog.toy = toy.clone();
        return thisDog;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", toy=" + toy +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }
}

class Toy  implements Cloneable{
    private String name;

    public Toy() {
    }

    public Toy(String name) {
        this.name = name;
    }
    @Override
    protected Toy clone() throws CloneNotSupportedException {
        return (Toy)super.clone();
    }
    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
