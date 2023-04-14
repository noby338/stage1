package note.emun;

/**
 * 枚举的定义
 * @author Noby
 * @since 2023/3/19 17:34
 */
enum MyColor {
    //常量：他们是当前枚举的对象 等同于：public static final MyColor RED = new MyColor("红色");
    RED("红色"), YELLOW("黄色"), BLUE("蓝色"), ORANGE("橘色");
    //属性：他们是当前枚举常量的属性
    private String value;

    //构造方法：用于给当前枚举常量赋属性值，访问修饰符只能使用 private(一般不写，默认为private)
    MyColor(String value) {
        this.value = value;
    }

    //方法：用于枚举常量调用
    public void method() {//常量为方法的调用对象
        System.out.println("MyColor method");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
