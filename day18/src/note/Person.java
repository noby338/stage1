package note;

import java.io.Serializable;

/**
 * 用于序列化测试的类
 * @author Noby
 * @since 2023/3/18
 */
public class Person implements Serializable {//实现序列化接口的类才可以序列化和反序列化
    /*
    序列化版本id，表示类的id
    如果反序列化和序列化时的id不同，反序列化将失败 InvalidClassException
    代码被修改后，该类不再是以前的类，而以前序列化生成的文件存入的是以前的类的对象
    而以前的类的对象并不属于现在的类，所以在代码修改后应该重新序列化，更新文件存入的对象
     */
    private static final long serialVersionUID = 1L;//在修改代码后，应该同时修改id，在反序列化时，只要id没变，就可反序列化成功（但会造成不可预计的问题）
    private String name;
    private int age;
    /*
    加上transient关键字的属性将不会被序列化
     */
    transient int weight;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
