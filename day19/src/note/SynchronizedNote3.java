package note;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock类实现锁功能
 *
 * 相比较其他两种方法更加灵活高级，其可在同步代码内出现异常时仍然可以释放锁
 */
public class SynchronizedNote3 {

    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();
        Thread thread = new Thread(ticket2);
        Thread thread1 = new Thread(ticket2);
        Thread thread2 = new Thread(ticket2);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class Ticket2 implements Runnable {
    int num = 100;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (num > 0) {
            lock.lock();
            try {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + num--);
                }
                int i = 1/0;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
