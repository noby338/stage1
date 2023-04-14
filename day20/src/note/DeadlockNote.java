package note;

/**
 * 死锁现象
 * 死锁产生的条件：多个线程争夺多个资源，并且因争夺资源相互等待
 * 在发生死锁的外面加上一把锁，可避免死锁的发生
 * @author Noby
 * @since 2023/3/19 1:12
 */
public class DeadlockNote {

    public static void main(String[] args) {
        //region
        MyRunnable a = new MyRunnable("哲学家A");
        MyRunnable b = new MyRunnable("哲学家B");

        new Thread(a).start();
        new Thread(b).start();
        //endregion

    }
}

class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
//            synchronized ("要拿拿两双") {
                if ("哲学家A".equals(name)) {
                    synchronized ("拿左筷子") {
                        System.out.println(name + "拿到了左筷子，准备拿右筷子");
//                    Thread.currentThread().stop();//此方法可以杀死线程，同样可以跳出死锁，但不推荐
                        synchronized ("拿右筷子") {
                            System.out.println(name + "拿到了右筷子，开吃");
                        }
                    }
                } else {
                    synchronized ("拿右筷子") {
                        System.out.println(name + "拿到了右筷子，准备拿左筷子");
                        synchronized ("拿左筷子") {
                            System.out.println(name + "拿到了左筷子，开吃");
                        }
                    }
                }
//            }
            System.out.println(name + "拿筷子结束");
        }
    }
    /*
    死锁解决方案：
    1. 杀掉其中一个线程
    2. 避免死锁发生（代码优化，再加一把锁）
     */
}
