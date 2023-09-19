package note;

/**
 * 同步方法实现锁功能
 *
 * 该方法相对同步代码块更加简单可读性高，但锁的范围不够灵活，效率不如同步代码块
 */
public class SynchronizedNote2 {

    public static void main(String[] args) {
        Ticket1 ticket1 = new Ticket1();
        Thread thread = new Thread(ticket1);
        Thread thread1 = new Thread(ticket1);
        Thread thread2 = new Thread(ticket1);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class Ticket1 implements Runnable {
    int num = 100;

    @Override
    public void run() {
        while (num > 0) {
            method();
        }
    }

    /*
    同步方法中成员方法的锁对象为this，静态方法的锁对象为当前类的字节码文件对象
     */
    private synchronized void method() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + num--);
        }
    }
}
