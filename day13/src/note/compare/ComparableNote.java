package note.compare;

import java.util.Arrays;

/**
 * @Description Comparable的使用
 * @Author Noby
 * @Date 2023/3/14 21:44
 */
public class ComparableNote {
    public static void main(String[] args) {
        Student[] students = {
                new Student("noby",1,2,3),
                new Student("java",10,200,30),
                new Student("a",10,200,18),
                new Student("tony",100,10,3)
        };
        Arrays.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student implements Comparable<Student>{
    private String name;
    private int chinese;
    private int math;
    private int english;

    public Student(String name,int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    @Override
    public int compareTo(Student o) {
        if (o.chinese == this.chinese) {
            if (o.math == this.math) {
                return this.name.compareTo(o.name);
            }
            return Integer.compare(o.math,this.math);
        }
        return Integer.compare(o.chinese, this.chinese);
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                '}';
    }
}
