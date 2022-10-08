package note.polymorphic.lowcoupling;

public abstract class Pet {
    String name;
    boolean isMale;

    public Pet(String name, boolean isMale) {
        this.name = name;
        this.isMale = isMale;
    }
}
