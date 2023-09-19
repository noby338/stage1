package note.senior;

/**
 * 线程的强制执行
 *
 * join()方法用于等待一个线程执行完毕。当一个线程调用另一个线程的join()方法时，它会被阻塞，直到被调用的线程执行完毕。
 * 具体来说，如果线程A调用了线程B的join()方法，那么线程A将会被挂起，直到线程B执行完毕。在这个过程中，线程A会进入等待状态，并释放CPU资源，直到线程B执行完毕后，线程A才会继续执行。
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

        //线程thread2相对线程thread0执行完之前等待，所以thread1不受影响
        thread0.start();
        thread1.start();
        thread2.start();

        System.out.println("main方法");
    }
}
