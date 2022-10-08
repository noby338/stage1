package note.polymorphic.lowcoupling;

public class Dog extends Pet {

    public Dog(String name, boolean isMale) {
        super(name, isMale);
    }


    @Override
    public String toString() {
        return "Dog";
    }
}
