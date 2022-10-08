package pra;


public class ClonePra {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person noby = new Person("noby", new FootBall());
        System.out.println(noby);

        Person kace = noby.clone();
        System.out.println(kace);


    }
}

class Person implements Cloneable{
    private String name;
    private Hoby hoby;

    public Person(String name, Hoby hoby) {
        this.name = name;
        this.hoby = hoby;
    }

    @Override
    public String toString() {
        return "Person{" +
                this.hashCode() +
                "name='" + name + '\'' +
                ", hoby=" + hoby +
                '}';
    }

    @Override
    public Person clone () throws CloneNotSupportedException {
        Person newPerson = (Person) super.clone();
        newPerson.hoby = hoby.clone();
        return newPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hoby getHoby() {
        return hoby;
    }

    public void setHoby(Hoby hoby) {
        this.hoby = hoby;
    }
}

abstract class Hoby implements Cloneable{
    public Hoby() {
    }

    @Override
    public String toString() {
        return "Hoby{}" + this.hashCode();
    }

    @Override
    public Hoby clone() throws CloneNotSupportedException {
        return (Hoby) super.clone();
    }
    abstract public void show();
}

class FootBall extends Hoby implements Cloneable{
    @Override
    public void show() {
        System.out.println("打篮球");
    }
}
