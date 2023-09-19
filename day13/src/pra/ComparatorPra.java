package pra;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorPra {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("1noby", 22, 100),
                new Person("3july", 21, 90),
                new Person("2kace", 21, 90)
        };
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int name = o1.name.compareTo(o2.name);
                int age = o2.age - o1.age;
                int score = o2.score - o2.score;
                if (score == 0) {
                    if (age == 0) {
                        return name;
                    } else {
                        return age;
                    }
                } else {
                    return score;
                }
            }
        });

        for (Person person : persons) {
            System.out.println(person);
        }
    }
}

class Person {
    String name;
    int age;
    int score;

    public Person(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}