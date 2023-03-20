package note.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//以下注解来自lombok插件及lombok的jar包
@Data//表示自动生成getter和setter
@NoArgsConstructor//表示自动生成无参构造函数
@AllArgsConstructor//表示自动生成全参构造函数
class Person {
    private String name;
    private int age;
    private static int numOfEyes;

    public void show() {
        System.out.println(name + "," + age);
    }

    public void say(String info, int num) {
        System.out.println("say " + info + ",I have say " + num + " times");
    }
}
