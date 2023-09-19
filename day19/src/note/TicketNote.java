package note;
/**
 * 线程安全问题（售票）
 * @author Noby
 * @since 2023/3/19 0:35
 */
public class TicketNote {

    public static void main(String[] args) throws InterruptedException {
        TicketThread ticket = new TicketThread();
        TicketThread ticket1 = new TicketThread();
        TicketThread ticket2 = new TicketThread();
        ticket.setName("1号窗口Thread");
        ticket1.setName("2号窗口Thread");
        ticket2.setName("3号窗口Thread");
        ticket.start();
        ticket1.start();
        ticket2.start();

        Thread.sleep(1000);
        System.out.println();

        TicketRunnable ticketRunnable = new TicketRunnable();
        Thread thread = new Thread(ticketRunnable);
        Thread thread1 = new Thread(ticketRunnable);
        Thread thread2 = new Thread(ticketRunnable);
        thread.setName("1号窗口Runnable");
        thread1.setName("2号窗口Runnable");
        thread2.setName("3号窗口Runnable");
        thread.start();
        thread1.start();
        thread2.start();

    }
}

class TicketThread extends Thread {
    static int num = 100;///此方法创建多线程只需创建多个TicketThread对象，因此为了使数据共享必须为静态变量
    @Override
    public void run() {
        while (true) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + num--);
            } else break;
        }
    }
}

class TicketRunnable implements Runnable {
    int num = 100;//此方法创建多线程只需创建一个TicketRunnable对象，因此成员变量即可实现共享数据
    @Override
    public void run() {
        while (true) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + num--);
            } else break;
        }
    }
}
