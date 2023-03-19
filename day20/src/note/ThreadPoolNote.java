package note;

import java.util.concurrent.*;

/**
 * Runnable 使用ThreadPoolExecutor线程池
 * ThreadPoolExecutor是Java中一个用于管理线程池的类，它可以方便地管理线程的创建、销毁和重用，以及控制线程池的大小和任务队列的容量。在ThreadPoolExecutor中，核心线程、任务队列和临时线程是线程池中的三个重要组成部分。
 * 核心线程：
 * 核心线程是线程池中最基本的部分，它们在线程池中始终存在，并且在没有任务执行时也不会被销毁。当有任务提交到线程池时，核心线程会立即执行任务，如果核心线程已经被全部占用，则会把任务放入任务队列中等待执行。线程池的核心线程数可以通过ThreadPoolExecutor的构造函数进行配置。
 * 任务队列：
 * 任务队列是用于存储等待执行的任务的数据结构。当线程池中的所有核心线程都被占用时，新提交的任务会被放入任务队列中等待执行。ThreadPoolExecutor中提供了多种类型的任务队列，如无界队列和有界队列等，开发者可以根据自己的需求进行选择。
 * 临时线程：
 * 当任务队列已经满了，或者线程池中的核心线程都在执行任务且任务队列中也已经没有任务等待执行时，ThreadPoolExecutor会创建临时线程来执行新提交的任务。临时线程是一种可灵活增减的线程，当任务执行完毕后，它们会被自动销毁。线程池中临时线程的数量可以通过ThreadPoolExecutor的构造函数进行配置。
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
