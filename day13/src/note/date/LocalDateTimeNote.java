package note.date;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class LocalDateTimeNote {//相比较Calendar和Date它的线程安全

    public static void main(String[] args) {
        //region 日期构造
        LocalDate localDate = LocalDate.now();
        LocalDateTime birthday = LocalDateTime.of(1999, 3, 11,4,50,20);
        System.out.println("localDate = " + localDate);
        //endregion

        //region 时间
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime);
        //endregion

        //region 日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        //endregion

    //region 日期时间格式化器
        //region 日期时间=>字符串
        System.out.println("日期时间=>字符串");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(localDateTime);
        System.out.println(format);
        //endregion
        //region 字符串=>日期时间
        System.out.println("字符串=>日期时间");
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("H:m");
        LocalTime parse = LocalTime.parse("7:30",dateTimeFormatter1);
        System.out.println(parse);
        //endregion
    //endregion

        //region 日期时间的转换
        LocalTime localTime1 = localDateTime.toLocalTime();
        LocalDate localDate1 = localDateTime.toLocalDate();
        //endregion

        //region 日期时间的计算，设置
        System.out.println("localTime.plusMinutes(3) = " + localTime.plusMinutes(3));
        System.out.println(localTime.withMinute(59));
        //endregion

        //region 判断时间先后
        System.out.println("localTime.isBefore(LocalTime.now()) = " + localTime.isBefore(LocalTime.now()));
        System.out.println("localTime.isAfter(localTime.now()) = " + localTime.isAfter(localTime.now()));
        //endregion
    }
}
