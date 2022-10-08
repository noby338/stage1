package note;

/**
 * 使用Runnable接口开启多线程
 *
 * 优点：实现Runnable接口的同时，还可以继承其他类，可扩展性好，操作共享数据方便
 * 缺点：代码复杂，不可获得任务的返回值
 */
public class RunnableNote {
    public static void main(String[] args) {
        MyRunnable4 myRunnable2 = new MyRunnable4();
        Thread thread = new Thread(myRunnable2,"T1");
        thread.start();

        MyRunnable4 myRunnable22 = new MyRunnable4();
        Thread thread2 = new Thread(myRunnable22,"T1");
        thread2.start();

    }
}

class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}