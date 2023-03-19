package note;

/**
 * 使用Thread类实现多线程
 *
 * 优点：代码简单
 * 缺点：在继承Thread类后不可继承其他类，扩展性差
 */
public class ThreadNote {

    public static void main(String[] args) {

        //region 构造
        Thread myThread = new MyThread();
        System.out.println(new MyThread("构造方法设置线程名").getName());
        //endregion

        //region 多线程开启 start 方法，底层使用c和c++调用操作系统的方法(start0())，开启多线程执行run方法
        //直接调用run()方法会当成普通方法执行，只有调用start()方法才是启动一个新的线程
        myThread.start();
        //endregion

        //region 主线程
        //同时存在主线程任务和子线程任务时，将子线程任务放在前面，否则永远是先执行完主线程任务(主线程任务执行时还没有开启子线程)
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + i);//Thread.currentThread()获取当前线程对象
        }
        //endregion

        //region 成员方法, 静态方法
        myThread.setName("支线程0");//设置线程名
        System.out.println(myThread.getName());//获取线程名
        System.out.println("myThread.getPriority() = " + myThread.getPriority());//获取优先级，默认为5，最高位10
        myThread.setPriority(1);//设置优先级(1——10)，优先级越大，抢占到CPU资源的概率大
        try {
            Thread.sleep(1000);//线程休眠，休眠当前运行的线程，休眠后没有抢占CPU资源的权限，时间结束后恢复权限
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程休眠结束");

        Thread.yield();//线程礼让：让出当前线程，让所有线程重新抢占CPU资源。
        try {
            myThread.join();//线程加入：强行让当前线程获取CPU资源，在当前线程执行完成后，再释放抢占CPU执行权限
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.setDaemon(true);//设置守护线程，守护线程在其他非守护线程结束时随之结束
        /*
        守护线程结束也需要一定的时间，而非立即结束
         */
        myThread.interrupt();//中断线程
        //endregion

        /*
        main()是入口方法，进入main()，即会开启主线程。
        主线程中还可以开启其他线程，主线程执行结束，进程不会结束，进程要等所有线程执行结束才会结束。
         */
    }
}

class MyThread extends Thread {//定义一个可以开启多线程的类
    public MyThread(String name) {
        super(name);//Thread类中的构造方法可以传入线程名
    }
    public MyThread(){}
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + i);//Thread中有getName方法，getName()为this.getName()的简写
        }
    }
}
