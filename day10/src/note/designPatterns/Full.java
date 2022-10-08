package note.designPatterns;
/**
 * 1. 私有化构造方法
 * 2. 声明一个私有静态指向本类对象的引用，并赋值为null
 * 3. 提供一个公共静态方法，返回值这一个引用(在第一次返回这个引用前创建这一个对象并让这个其指向这一个引用)
 */
class Full {//懒汉式设计模式方式一(优点：没有过早的进入内存 缺点：有线程安全问题，可能创建多个对象)
    private static Full instance;
    private Full() {
    }

    public static Full getInstance () {
        if (instance == null) {
            instance = new Full();
        }
        return instance;
    }
}

class Full2 {//懒汉式设计模式方式二(优点：无线程安全问题 缺点：每次执行都要判断锁对象状态，低效)
    private static Full2 singleton;

    private Full2() {
    }

    public static synchronized Full2 getInstance() {
        if (singleton == null) {
            singleton = new Full2();
        }
        return singleton;
    }
}

class Full3 {//懒汉式设计模式方式三(优点：高效，只在第一次执行判断锁对象状态，无线程安全问题 缺点：无)
    private static Full3 singleton;

    private Full3() {
    }

    public static Full3 getInstance() {
        if (singleton == null) {
            synchronized (Full3.class) {
                if (singleton == null) {
                    singleton = new Full3();
                }
            }
        }
        return singleton;
    }
}
