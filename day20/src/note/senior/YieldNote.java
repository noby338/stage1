package note.senior;

/**
 * 线程的礼让
 *
 * Tread的静态方法，让抢占到cpu执行权的当前线程让出此次的执行机会，让其他线程重新抢占CPU
 * @author Noby
 * @since 2022/10/3
 */
public class YieldNote {
    public static void main(String[] args) {
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    if (i % 3 == 0) {
                        System.out.println("线程礼让");
                        //线程礼让：让出当前线程，让所有线程重新抢占CPU资源。
                        Thread.yield();
                    }
                }
            }
        };

        thread0.start();
        thread1.start();
        thread2.start();

        System.out.println("main方法");

    }
}
