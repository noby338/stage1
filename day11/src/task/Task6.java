package task;

import java.util.Scanner;

public class Task6 {
/*
6.需求：以字符串的形式从键盘录入学生信息，例如："张三,23" 从该字符串中切割出有效数据，封装为Student学生对象
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生数据(如：张三,23)");
        String scanString =  scanner.nextLine();
        Student student = new Student(scanString.split(",")[0], Integer.parseInt(scanString.split(",")[1]));
        System.out.println(student);
    }
}
class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
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
}
