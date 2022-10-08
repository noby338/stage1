package note;

/**
 * 同步代码块实现锁功能
 *
 * 该方法相对比同步方法，灵活度更高，性能更好，锁的范围可设置得更小
 */
public class SynchronizedNote {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread = new Thread(ticket);
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class Ticket implements Runnable {
    int num = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {//this对象为锁对象(可以为任意对象，但是实现锁功能的每个线程都要是同一对象，一般设置为共享资源)
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + num--);
                } else break;
            }
        }
    }
}
