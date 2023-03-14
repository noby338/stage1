package note.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Comparator的使用
 */
public class ComparatorNote {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("b", 21),
                new Person("kace", 22),
                new Person("a", 21),
        };
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int age = Integer.compare(o1.getAge(), o2.getAge());
                int name = o2.getName().compareTo(o1.getName());
                if (age == 0) {
                    return name;
                }
                return age;
            }
        });
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}

class Person {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
