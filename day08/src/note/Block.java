package note;

class Block {
    private String name;
    private static int age;//static声明的属性、方法、代码块在类加载(获得字节码文件对象)(第一次new或通过类使用静态类变量)时创建

    //region 静态代码块
    /*
    静态代码块在第一次使用该类时执行，且只执行一次
     */
    static {
        System.out.println("静态代码块执行");
//        System.out.println(this.name);静态代码块不能访问非静态属性
        System.out.println("Block.age = " + Block.age);
    }
    //endregion

    //region 非静态代码块
    /*
    非静态代码块在调用构造方法前执行，构造方法被调用几次，就执行几次
    经常用来在创建对象之前做准备工作
     */
    {
        System.out.println("非静态代码块执行");
        System.out.println("this.name = " + this.name);
        System.out.println("Block.age = " + Block.age);
    }
    //endregion

    public Block() {
        System.out.println("无参构造方法执行");
    }
}
