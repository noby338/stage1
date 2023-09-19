package pra;

import java.util.Calendar;
import java.util.Date;

public class CalendarPra {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999,3,26);
        System.out.println("calendar.get(Calendar.MONTH) = " + calendar.get(Calendar.MONTH));
        calendar.set(Calendar.SECOND,0);
        System.out.println(Calendar.getInstance().get(Calendar.SECOND) - calendar.get(Calendar.SECOND));
        calendar.add(Calendar.YEAR,1);
        System.out.println(calendar.get(Calendar.YEAR));
        Date time = calendar.getTime();
        System.out.println(time);
    }
}
