package pra;

import java.util.Arrays;

public class ComparablePra {
    public static void main(String[] args) {
        Student[] students = {
                new Student("3noby", 20, 90),
                new Student("1kace", 20, 90),
                new Student("2jully", 21, 80)
        };
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

    }
}

class Student implements Comparable<Student>{
    String name;
    int age;
    int score;

    @Override
    public String toString() {
        return "Student{" +
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

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student s) {
        int scoreSort = score - s.score;
        int ageSort = age - s.age;
        int nameSort = name.compareTo(s.name);

        if (scoreSort == 0) {
            if (ageSort == 0) {
                return nameSort;
            } else {
                return scoreSort;
            }
        } else {
            return scoreSort;
        }
    }
}