package note.senior;

/**
 * 线程的优先级的设置
 * <p>
 * 优先级较高的线程获得抢占到cup执行权的概率较大，且获得的每次抢占到资源后获得的执行时间较长
 *
 * @author Noby
 * @since 2022/10/3
 */
public class PriorityNote {
    public static void main(String[] args) {
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        };

        //优先级的等级分为1-10，数字越大优先级越高，所有的线程默认为5
        thread0.setPriority(Thread.MAX_PRIORITY);//MAX_PRIORITY为10
        thread1.setPriority(Thread.MIN_PRIORITY);//MIN_PRIORITY为1
        System.out.println("thread2.getPriority() = " + thread2.getPriority());

        thread0.start();
        thread1.start();
        thread2.start();

        System.out.println("main方法");
    }
}
