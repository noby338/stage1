package note;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description Timer定时器的基本使用
 * Timer 是定时器线程池的单线程简化，处理多个任务按照顺序执行，存在延时与设置定时器的时间有出入。
 * 可能因为其中的某个任务的异常使Timer线程死掉，从而影响后续任务执行。
 * @Author Noby
 * @Date 2023/3/19
 */
public class TimerNote {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行AAA~~~" + new Date());

            }
        }, 0, 2000);

        //此任务中的异常会导致Timer线程死掉，从而影响其他任务执行。
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行BBB~~~" + new Date());
                System.out.println(10 / 0);
            }
        }, 0, 2000);

        //此任务中的延时会导致Timer线程中其他任务的不准时。
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行CCC~~~" + new Date());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2000);
    }
}
