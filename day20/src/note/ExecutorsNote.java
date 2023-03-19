package note;

import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 通过Executors创建线程池
 * <p>
 * Executors的底层其实也是基于线程池的实现类ThreadPoolExecutor创建线程池对象的
 * 相对于ThreadPoolExecutor来说，虽然编码简单，但部分不可控，具有风险
 *
 * @author Noby
 * @since 2022/10/2
 */
public class ExecutorsNote {
    public static void main(String[] args) {
//        myNewCachedThreadPool();
//        myNewFixedThreadPool();
//        myNewSingleThreadExecutor();
        myNewScheduledThreadPool();
    }

    /**
     * 缓存线程池
     * <p>
     * 线程数量随着任务增加而增加，如果线程任务执行完毕且空闲了一段时间则会被回收掉。
     * 线程数量的最大上限为无限，可能出现内存溢出异常
     */
    static void myNewCachedThreadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();
        MyRunnable4 myRunnable4 = new MyRunnable4();

        /*
        execute()方法用于提交一个Runnable任务到线程池中执行。它的作用是将一个任务交给线程池，由线程池中的线程来执行。
        执行execute()方法后，线程池会选择一个空闲的线程来执行任务，如果没有空闲线程，则将任务放入任务队列等待执行。
         */
        pool.execute(myRunnable4);
        pool.execute(myRunnable4);
        pool.execute(myRunnable4);
        pool.execute(myRunnable4);

        //关闭线程池
        pool.shutdown();
    }

    /**
     * 固定线程池
     * <p>
     * 创建固定线程数量的线程池，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程替代它。
     * 任务队列的长度可以为无限，可能出现内存溢出异常
     */
    static void myNewFixedThreadPool() {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        MyRunnable4 myRunnable4 = new MyRunnable4();

        pool.execute(myRunnable4);
        pool.execute(myRunnable4);
        pool.execute(myRunnable4);
        pool.execute(myRunnable4);

        //关闭线程池
        pool.shutdown();
    }

    /**
     * 单线程池
     * <p>
     * 创建只有一个线程的线程池对象，如果该线程出现异常而结束，那么线程池会补充一个新线程。
     * 任务队列的长度可以为无限，可能出现内存溢出异常
     */
    static void myNewSingleThreadExecutor() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        MyRunnable4 myRunnable4 = new MyRunnable4();

        pool.execute(myRunnable4);
        pool.execute(myRunnable4);
        pool.execute(myRunnable4);
        pool.execute(myRunnable4);

        //关闭线程池
        pool.shutdown();
    }

    /**
     * 定时线程池
     * <p>
     * 创建一个线程池，可以实现在给定的延迟后运行任务，或者定期执行任务。
     * 线程数量的最大上限为无限，可能出现内存溢出异常
     */
    static void myNewScheduledThreadPool() {
        //参数: 核心线程数量(超过核心线程数量时会自动创建临时线程)
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);

        // 添加任务
        // 参数1：执行的任务 TimerTask为Runnable接口的实现类(可传入Runnable接口的其他实现类)
        // 参数2：延时调度时间
        // 参数3：周期调度时间
        // 参数4：时间单位
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行AAA~~~" + new Date());
            }
        }, 0, 1, TimeUnit.SECONDS);

        //此任务中的异常不会导致其他线程的定时任务死掉。
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行BBB~~~" + new Date());
                int i = 1 / 0;
            }
        }, 0, 1, TimeUnit.SECONDS);

        //此任务中的延时不会导致其他线程中的任务不准时。
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行CCC~~~" + new Date());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);

    }


}

class MyRunnable4 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
//        try {
//            System.out.println(Thread.currentThread().getName() + " 线程开始休眠");
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
