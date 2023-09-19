package note;

/*
创建class文件即为创建类，一个Class文件即为一个类
一个java文件中可以有多个类(实际开发中一个文件一般只写一个类)，但是只能有一个public修饰的类(public修饰的类名和java文件名一致，该类为主类，存在main()方法)
main()方法只能存在主类中(public修饰的类)*未解
一个Java文件若有多个类，则在编译时会生成每个类的class文件
*/
public class Class_PackageNote {//类和对象、包的封装

    public static void main(String[] args) {
        //region 通过类创建对象
        Person noby = new Person("noby", 21);
        /*
        该过程分为大三步：
        1.Person noby 声明Person类的引用变量，该变量的变量名为noby
        2.new Person() 创建Person对象
            2.1.通过不同的参数列表调用不同的Person()方法(构造器、构造方法)(方法重载)
            2.2.返回该对象的引用
        3.“=”  把Person对象的引用(地址)赋值给引用变量noby
         */
        //endregion

        //region 通过对象调用方法
        noby.getClassName();
        noby.show();
        //endregion

        //region 设置属性和获取属性
        noby.setAge(-1);//此处赋值失败，因为Person类中的setAge()方法中对传入的数据进行的校验
        System.out.println(noby.getAge());
        //endregion

    }
}

class Person {

    //region 成员变量(属性)：该类具有的特征
    /*
    private 对属性进行封装，表示除了本类，其他类不可访问
    如：在ClassName类的main()方法中无法通过 对象名.属性 的方式给属性赋值或获取属性的数据
     */
    private String name = "noby";
    private int age = 21;
    //endregion

    //region 成员方法(行为)；该类具有的行为
    void getClassName() {//未使用成员变量的成员方法
        System.out.println("This is Person Class");
    }

    void show() {//使用成员变量的成员方法
        String name = "kace";
        System.out.println("name = " + name);
        System.out.println(this.name + "," + this.age);//this表示调用此方法的实例对象的引用
        //当show()方法中没有定义name局部变量时，this.name可以简写为name(jvm编译后会自动加上this)，此时的name就是this.name
    }
    //endregion


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
        //region 此处可以进行数据校验，但一般不在此处校验，一般校验在前端的表单进行
        if (age < 0) {
            return;
        }
        //endregion
        this.age = age;
    }

    //region 无参构造方法 当类中未写任何构造方法时，编译器会自动添加一个无参构造方法
    public Person() {//new Person()调用该方法
    }
    //endregion

    //region 有参构造方法(当参数列表包含了所有成员变量时，为全参构造方法)
    public Person(String name, int age) {//new Person(String，int) 调用该方法
        //region 将构造函数参数列表中的参数赋值给类的成员变量
        this.name = name;
        this.age = age;
        //region
        //jvm生成构造函数的返回值，该返回值为一个此类的对象
    }
    //endregion

    //region 构造函数可以根据成员方法随意排列组合，不同的排列组合为不同的构造函数，只有类中有该构造函数时
    public Person(int age, String name) {//这,int age)不同和public Person(String name
        this.name = name;
        this.age = age;
    }
    //endregion
}
