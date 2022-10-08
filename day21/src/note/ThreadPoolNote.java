package note;

import java.util.concurrent.*;

public class ThreadPoolNote {//线程池

    public static void main(String[] args) {
        //region 未使用线程池，直接创建线程调用
//        new Thread(new MyRunnable("多线程A")).start();
//        new Thread(new MyRunnable("多线程B")).start();
//        new Thread(new MyRunnable("多线程C")).start();
//        new Thread(new MyRunnable("多线程D")).start();
//        new Thread(new MyRunnable("多线程E")).start();
//        new Thread(new MyRunnable("多线程F")).start();
        //endregion

        //region 单线程池
//        singlePool();
        //endregion

        //region 固定线程池
//        fixedPool();
        //endregion

        //region 缓存线程池
//        cachePool();
        //endregion

        //region 定时线程池
//        schedulePool();
        //endregion

        //region 自定义线程池
        customPool();
        //endregion

    }

    public static void singlePool() {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        // 添加任务，让线程池执行任务
        pool.execute(new MyRunnable("singlePoolA"));
        pool.execute(new MyRunnable("singlePoolB"));
        pool.execute(new MyRunnable("singlePoolC"));
        pool.execute(new MyRunnable("singlePoolD"));
        pool.execute(new MyRunnable("singlePoolE"));
        pool.execute(new MyRunnable("singlePoolF"));

        // 线程池用完之后需要关闭，否则程序一直执行
        pool.shutdown();
    }

    // 固定线程池
    public static void fixedPool() {
        // 参数：线程的数量
        ExecutorService pool = Executors.newFixedThreadPool(3);

        // 添加任务，让线程池执行任务
        pool.execute(new MyRunnable("fixedPoolA"));
        pool.execute(new MyRunnable("fixedPoolB"));
        pool.execute(new MyRunnable("fixedPoolC"));
        pool.execute(new MyRunnable("fixedPoolD"));
        pool.execute(new MyRunnable("fixedPoolE"));
        pool.execute(new MyRunnable("fixedPoolF"));

        pool.shutdown();
    }

    // 缓存线程池：可变线程池
    public static void cachePool() {
        // 线程数量根据任务数量随时变化
        ExecutorService pool = Executors.newCachedThreadPool();

        // 添加任务，让线程池执行任务(18个线程)
        pool.execute(new MyRunnable("fixedPoolA"));
        pool.execute(new MyRunnable("fixedPoolB"));
        pool.execute(new MyRunnable("fixedPoolC"));
        pool.execute(new MyRunnable("fixedPoolD"));
        pool.execute(new MyRunnable("fixedPoolE"));
        pool.execute(new MyRunnable("fixedPoolF"));
        pool.execute(new MyRunnable("fixedPoolG"));
        pool.execute(new MyRunnable("fixedPoolH"));
        pool.execute(new MyRunnable("fixedPoolI"));
        pool.execute(new MyRunnable("fixedPoolG"));
        pool.execute(new MyRunnable("fixedPoolK"));
        pool.execute(new MyRunnable("fixedPoolL"));
        pool.execute(new MyRunnable("fixedPoolM"));
        pool.execute(new MyRunnable("fixedPoolN"));
        pool.execute(new MyRunnable("fixedPoolO"));
        pool.execute(new MyRunnable("fixedPoolP"));
        pool.execute(new MyRunnable("fixedPoolQ"));
        pool.execute(new MyRunnable("fixedPoolR"));

        pool.shutdown();
    }

    // 定时线程池
    public static void schedulePool() {
        // 参数：线程的数量
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);

        // 添加任务
        // 参数1：执行的任务
        // 参数2：延迟
        // 参数3：间隔时间
        // 参数4：时间单位
        pool.scheduleAtFixedRate(new MyRunnable("定时线程池"), 0, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }

    // 自定义线程池
    public static void customPool() {
        // 创建对象
        // 参数1：核心线程数量，在创建线程时初始数量
        // 参数2：最大线程数
        // 参数3：线程发呆时间，没有执行任务的线程空闲时间
        // 参数4：时间单位
        // 参数5：存放任务的队列
        // 参数6：线程工厂，生产线程、创建线程
        // 参数7：处理器，执行任务发生问题时怎么处理任务
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                10,
                100,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                }, new ThreadPoolExecutor.DiscardPolicy());

        // 执行任务
        pool.execute(new MyRunnable("customPoolA"));
        pool.execute(new MyRunnable("customPoolB"));
        pool.execute(new MyRunnable("customPoolC"));
        pool.execute(new MyRunnable("customPoolD"));
        pool.execute(new MyRunnable("customPoolE"));
        pool.execute(new MyRunnable("customPoolF"));
    }
}

class MyRunnable implements Runnable {
    String name;//任务名

    public MyRunnable(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行" + name);
        /*
        getId()获取线程的id值
         */
    }
}
