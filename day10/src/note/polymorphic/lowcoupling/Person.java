package note.polymorphic.lowcoupling;

public class Person {
    String name;
    Pet pet;//这里的宠物不写特定的某一种宠物，而是pet，实现低耦合
    public void show() {
        System.out.printf("我的名字叫%s，我养了一只%s，它的名字叫%s" ,this.name,pet,pet.name);
        System.out.println();
    }

    public Person(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }
}
