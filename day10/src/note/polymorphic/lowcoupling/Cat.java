package note.polymorphic.lowcoupling;

public class Cat extends Pet{
    public Cat(String name, boolean isMale) {
        super(name, isMale);
    }

    @Override
    public String toString() {
        return "Cat";
    }

}
