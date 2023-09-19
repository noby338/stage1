package note.designPatterns;

/**
 * 1. 私有化构造方法
 * 2. 声明一个私有静态指向本类对象的引用
 * 3. 提供一个公开、静态的方法，用来返回这个引用
 */
public class Hungry {//饿汉式设计模式(优点：无线程安全问题 缺点：在第一次加载类后，资源被创建，占用资源)
    private static final Hungry instance = new Hungry();

    private Hungry () {

    }

    public static Hungry getInstance() {
        return instance;
    }
}
