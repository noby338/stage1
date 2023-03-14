package note;
/*
 * 实体类：与指定的表进行对应
 * 	指定属性：类型、名字与相关的字段进行对应，一般情况下表中几个字段实体类就有几个属性
 * 	指定属性的setter和getter
 */
public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
