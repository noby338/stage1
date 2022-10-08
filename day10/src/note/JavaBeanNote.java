package note;
/*
 * 该类由public修饰
 * 该类实现Serializable接口
 * 该类中的属性由private修饰
 * 该类中有getter()、setter()方法
 * 该类有public无参构造函数
 */
public class JavaBeanNote{//java豆
    private String name;
    private int age;

    public JavaBeanNote() {
    }

    public JavaBeanNote(String name, int age) {
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
}
