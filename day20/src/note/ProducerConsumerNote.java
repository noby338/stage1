package note;
/**
 * @Description 利用锁实现生产者消费者模式
 * @Author Noby
 * @Date 2023/3/19 1:12
 */
public class ProducerConsumerNote {

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer("汽车");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    producerConsumer.consumer();
                }
            }
        },"消费线程");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    producerConsumer.producer();
                }
            }
        },"生产线程");

        thread.start();
        thread2.start();

    }
}

class ProducerConsumer{
    public String name;//商品的名字
    public int id = 1;//商品的编号
    public boolean isHaveProduct = false;//标记是否有商品

    public ProducerConsumer(String name) {
        this.name = name;
    }

    //无商品生产
    public synchronized void producer() {//模拟生产者
        if (isHaveProduct) {//有商品就执行等待，等待执行消费后唤醒
            try {
                wait();//object 方法，让线程阻塞，当线程被唤醒才能进入就绪状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产者生产了一个" + name + "  id:" + id++);
        isHaveProduct = true;
        notify();
//        notifyAll();//唤醒所有阻塞状态的线程
    }

    //有商品消费
    public synchronized void consumer() {//模拟消费者
        if (!isHaveProduct) {//没有商品就执行等待，等待执行生产后唤醒
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者消费了一个" + name + "  id:" + id);
        isHaveProduct = false;
        notify();
//        notifyAll();
    }
}
