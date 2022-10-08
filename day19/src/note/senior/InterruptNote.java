package note.senior;

/**
 * 线程的中断 成员方法interrupt()
 *
 * 所有的线程都可以中断，中断的线程必须进行异常的处理
 * @author Noby
 * @since 2022/10/2
 */
public class InterruptNote {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("开始休眠");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {//中断异常
                    e.printStackTrace();
                    System.out.println("休眠被中断");
                }
                System.out.println("休眠结束");
            }
        };
        thread.start();

        if (!thread.isInterrupted()) {
            thread.interrupt();
        }
    }
}
