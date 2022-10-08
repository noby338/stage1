package note.senior;

/**
 * 如何优雅地停止一个线程
 *
 * @author Noby
 * @since 2022/10/3
 */
//停止多线程：public void stop();
//销毁多线程：public void destroy();
//挂起线程(暂停执行)：public final void suspend();
//恢复挂起的线程执行：public final void resume();
//之所以废除掉这些方法，主要的原因是因为这些方法有可能导致线程的死锁
public class Stop {
    public static boolean flag = true;
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                long num = 0;
                while (flag) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在运行 num = " + num++);
                }
            }
        }.start();

        try {
            Thread.sleep(200);//运行200毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;//停止线程
    }
}
