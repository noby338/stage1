package note.senior;

/**
 * 线程的强制执行
 *
 * 主线程等待该子线程执行完之后才执行
 * @author Noby
 * @since 2022/10/2
 */
public class JoinNote {
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

        //这里的thread2为主线程而非main方法，主线程和子线程为一个相对的概念
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    if (i == 3) {
                        try {
                            System.out.println("开始"+thread0.getName()+"线程的强制执行!");
                            thread0.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        //主线程thread2相对子线程thread0执行完之前等待，所以thread1不受影响
        thread0.start();
        thread1.start();
        thread2.start();

        System.out.println("main方法");
    }
}
