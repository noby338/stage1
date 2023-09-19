package pra;

import org.omg.CORBA.Current;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePra {
    public static void main(String[] args) throws InterruptedException, ParseException {
        Date startTime = new Date();
        Thread.sleep(2000);
        Date endTime = new Date();
        System.out.println("经过的时间为：" + (endTime.getSeconds() - startTime.getSeconds()) + "秒");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date parsedate = simpleDateFormat.parse("23:11:22");
        Date parsedate1 = simpleDateFormat.parse("23:12:1");
        System.out.println((parsedate1.getTime() - parsedate.getTime())/1000);
        String format = simpleDateFormat.format(startTime);
        System.out.println(format);
    }
}
