package note;

import java.util.concurrent.*;

/**
 * Runnable 使用ThreadPoolExecutor线程池
 * @author Noby
 * @since 2022/10/2
 */
public class ThreadPoolNote {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,
                5, 6, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //参数一：指定线程池的线程数量（核心线程）：corePoolSize
        //参数二：指定线程池可支持的最大线程数：maximumPoolSize
        //参数三：指定临时线程的最大存活时间：keepAliveTime
        //参数四：指定存活时间的单位（秒、分、时、天）：unit
        //参数五：指定任务队列：workQueue
        //参数六：指定用哪个线程工厂创建线程：threadFactory
        //参数七：指定线程忙，任务满的时候，新任务来了怎么办：handler
        //临时线程什么时候创建？
        //新任务提交时发现核心线程都在忙，任务队列也满了，并且还可以创建临时线程，此时才会创建临时线程。
        //什么时候会开始拒绝任务？
        //核心线程和临时线程都在忙，任务队列也满了，新的任务过来的时候才会开始任务拒绝。

        MyRunnable3 myRunnable3 = new MyRunnable3();

        //以下三个线程只会使用核心线程
        pool.execute(myRunnable3);
        pool.execute(myRunnable3);
        pool.execute(myRunnable3);

        //以下五个线程会放入任务队列
        pool.execute(myRunnable3);
        pool.execute(myRunnable3);
        pool.execute(myRunnable3);
        pool.execute(myRunnable3);
        pool.execute(myRunnable3);

        //以下两个线程会创建临时线程
        pool.execute(myRunnable3);
        pool.execute(myRunnable3);

        //以下线程会触发新任务拒绝策略 new ThreadPoolExecutor.AbortPolicy()，抛出异常
//        pool.execute(myRunnable3);

    }
}

class MyRunnable3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        try {
            System.out.println(Thread.currentThread().getName() + " 线程开始休眠");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
