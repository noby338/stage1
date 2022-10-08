package note.senior;

/**
 * 线程间的通信(本类演示的是等待通知机制属于线程通信的一种)
 * <p>
 * wait(),notify(),notifyAll() 为object方法   sleep()为Thread类静态方法
 * 等待池：被调用wait()方法的线程存在于等待池，锁池：具有抢占锁对象的线程存在于锁池
 *
 * wait()方法必须在锁内，调用wait()方法后立即释放锁，并且让该线程一直处于阻塞状态直到被唤醒，wait(long millis)方法可以等待设置时间后自动唤醒
 * notify()方法随机唤醒对象的等待池中的一个线程，进入锁池，notifyAll()唤醒对象的等待池中的所有线程，进入锁池。
 *
 *
 * @author Noby
 * @since 2022/10/3
 */
public class ThreadCommunication {
    public static void main(String[] args) {
        WaitNotifyNote waitNotifyNote = new WaitNotifyNote();

        Thread thread = new Thread("线程0") {
            @Override
            public void run() {
                waitNotifyNote.fn();
            }
        };

        Thread thread2 = new Thread("线程1") {
            @Override
            public void run() {
                waitNotifyNote.fn();
            }
        };
        Thread thread3 = new Thread("线程2") {
            @Override
            public void run() {
                waitNotifyNote.fn();
            }
        };

        thread.start();
        thread2.start();
//        thread3.start();


    }
}

class WaitNotifyNote {
    public int state = 0;

    void fn() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " 正在执行 " + i);
                if (Integer.parseInt(Thread.currentThread().getName().substring(Thread.currentThread().getName().length() - 1)) != state % 2) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "被wait() " + i);
                        //wait()方法必须在锁内，调用wait()方法后立即释放锁，并且让该线程一直处于阻塞状态直到被唤醒
                        wait();
                        System.out.println(Thread.currentThread().getName() + "被notify() " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " 执行完成 " + i + "\n");
                state++;
                //notify()方法必须在锁内，随机唤醒对象的等待池中的一个线程，notify()不会立即释放锁，当执行完同步代码块就会释放对象的锁
                notify();
                //notifyAll()方法必须在锁内，唤醒对象的等待池中的所有线程，进入锁池。
//                notifyAll();
            }
        }

    }
}
