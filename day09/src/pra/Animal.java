package pra;

/**
 * @author Noby
 * @since 2023/3/10
 */
public abstract class Animal {
    private String color;

    public abstract void absFun();
    public void show() {
        System.out.println("抽象类可以有非抽象方法");
    }
}
