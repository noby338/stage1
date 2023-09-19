package note;

public class ToStringNote {
    public static void main(String[] args) {
        Person person = new Person("noby",34);
        System.out.println(person);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //region 重写toString方法
    @Override
    public String toString() {//方法用来将对象地址值转换为字符串，书写该对象名调用
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //endregion
}