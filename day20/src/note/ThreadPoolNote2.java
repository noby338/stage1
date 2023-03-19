package note;

import java.util.concurrent.*;

/**
 * Callable 使用ThreadPoolExecutor线程池
 * @author Noby
 * @since 2022/10/2
 */
public class ThreadPoolNote2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
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

        MyCallable2 myCallable2 = new MyCallable2(5);

        //以下三个线程只会使用核心线程
        Future<String> f = pool.submit(myCallable2);
        Future<String> f2 = pool.submit(myCallable2);
        Future<String> f3 = pool.submit(myCallable2);
        Future<String> f4 = pool.submit(myCallable2);

        System.out.println(f.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
    }
}

class MyCallable2 implements Callable<String> {
    private int n;

    public MyCallable2(int n) {
        this.n = n;
    }

    /**
     * 2、重写call()任务方法
     *
     * @return
     */
    @Override
    public String call() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return Thread.currentThread().getName() + " 计算的结果为：" + sum;
    }
}