package note.date;

import java.util.Calendar;
import java.util.Date;

public class CalendarNote {
    public static void main(String[] args) {
        //region 构造方法
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar = " + calendar);
        //endregion

        //region 时间的设置
        calendar.set(Calendar.YEAR,2022);
        calendar.set(1999,3,26);//此处的3表示4月
        calendar.set(1999,3,26,4,50);
        calendar.set(1999,3,26,4,50,60);
        //endregion

        //region 时间的转换
        Date date = calendar.getTime();
        //endregion

        //region 时间的获取
        System.out.println("calendar.get(Calendar.YEAR) = " + calendar.get(Calendar.YEAR));
        System.out.println("calendar.get(Calendar.MONTH) = " + calendar.get(Calendar.MONTH));//月份为0-11
        System.out.println("calendar.get(Calendar.DAY_OF_MONTH) = " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("calendar.get(Calendar.DAY_OF_WEEK) = " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("calendar.get(Calendar.HOUR_OF_DAY) = " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("calendar.get(Calendar.MINUTE) = " + calendar.get(Calendar.MINUTE));
        System.out.println("calendar.get(Calendar.SECOND) = " + calendar.get(Calendar.SECOND));
        //endregion

        //region 时间的加减
        calendar.add(Calendar.YEAR,2);
        System.out.println("calendar.get(Calendar.YEAR) = " + calendar.get(Calendar.YEAR));
        //endregion

        //region 时间的先后
        System.out.println("calendar.before(Calendar.getInstance()) = " + calendar.before(Calendar.getInstance()));
        System.out.println("calendar.after(Calendar.getInstance()) = " + calendar.after(Calendar.getInstance()));
        //endregion
    }
}
