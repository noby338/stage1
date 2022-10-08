package note.generic;

public class Instanceof_GetclassNote {
    public static void main(String[] args) {
        //region instanceof
        Animal animal = new Dog();
        if (animal instanceof Dog) {//true
            Dog dog = (Dog) animal;
        }
        System.out.println(animal instanceof Animal);//true
        //endregion

        //region getClass
        System.out.println(animal.getClass());
        /*
        class note.generic.Dog
        得到class 包名+类名
         */
        //endregion

    }
}
class Animal {
    int weight;
}

class Dog extends Animal{
    String name;
}