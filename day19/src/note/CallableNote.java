package note;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 使用callable接口和FutureTask类实现具有任务返回值的多线程
 *
 * 优点：相较于Runnable可获得多线程任务的返回值
 * 缺点：代码复杂
 */
public class CallableNote {
    public static void main(String[] args) throws Exception {
        //region 第一个线程
        //3、创建任务对象
        MyCallable myCallable = new MyCallable(10);
        //4、创建FutureTask对象
        FutureTask<String> futureTask = new FutureTask<>(myCallable);//FutureTask中文未来任务
        //5、创建Tread对象
        Thread thread = new Thread(futureTask);
        //6、调用Thread.start()方法
        thread.start();
        //7、调用futureTask.get()方法获取任务返回的结果，
        //如果futureTask任务没有执行完毕，这里的代码会等待，直到线程myCallable跑完才提取结果。
        System.out.println("futureTask.get() = " + futureTask.get());
        //endregion 第一个线程


        //region 第二个线程
        MyCallable myCallable2 = new MyCallable(100);
        FutureTask<String> futureTask2 = new FutureTask<>(myCallable2);
        Thread thread2 = new Thread(futureTask2);
        thread2.start();
        System.out.println("futureTask2.get() = " + futureTask2.get());
        //endregion 第二个线程
    }
}

/**
 * 1、定义一个实现Callable接口的任务类
 */
class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
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
        return "计算的结果为：" + sum;
    }
}
