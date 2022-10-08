package note;

import java.util.Timer;
import java.util.TimerTask;

public class TimerNote {//定时器
    public static void main(String[] args) {
        //region 构造
        Timer timer = new Timer();
        //endregion

        //region 添加任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                print();
            }
        }, 2000, 1000);//定时任务，延时时间，间隔时间
        //endregion


    }
    static void print(){
        System.out.println("执行了一次任务");
    }
}
