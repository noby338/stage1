package note.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeNote {//相比较Calendar和Date它的线程安全

    public static void main(String[] args) {
        //region 日期构造
        LocalDate localDate = LocalDate.now();
        LocalDate birthday = LocalDate.of(1999, 3, 11);
        System.out.println("birthday = " + birthday);
        System.out.println("localDate = " + localDate);
        //endregion

        //region 时间构造
        LocalTime localTime = LocalTime.now();
        LocalTime atime = LocalTime.of(12, 45);
        System.out.println("atime = " + atime);
        System.out.println("localTime = " + localTime);

        //region 日期时间构造
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime alarm = LocalDateTime.of(1999, 3, 11,4,50,20);
        System.out.println("alarm = " + alarm);
        System.out.println("localDateTime = " + localDateTime);
        //endregion

    //region 日期时间格式化器
        //region 日期时间=>字符串
        System.out.println("日期时间=>字符串");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTimeFormatter = dateTimeFormatter.format(localDateTime);
        System.out.println("formatDateTimeFormatter = " + formatDateTimeFormatter);
        //endregion
        //region 字符串=>日期时间
        System.out.println("字符串=>日期时间");
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parseLocalDateTime = LocalDateTime.parse("2001-08-23 23:07:30",dateTimeFormatter1);
        System.out.println("parseLocalDateTime = " + parseLocalDateTime);
        //endregion
    //endregion

        //region 日期时间的转换
        System.out.println("localDateTime.toLocalTime() = " + localDateTime.toLocalTime());
        System.out.println("localDateTime.toLocalDate() = " + localDateTime.toLocalDate());
        //endregion

        //region 日期时间的计算，设置
        System.out.println("localTime.plusMinutes(3) = " + localTime.plusMinutes(3));
        System.out.println("localDate.plusDays(-2) = " + localDate.plusDays(-2));
        System.out.println("localDateTime.plusWeeks(7) = " + localDateTime.plusWeeks(7));
        System.out.println("localTime.withHour(1) = " + localTime.withHour(1));
        System.out.println("localTime.withMinute(59) = " + localTime.withMinute(59));
        System.out.println("localTime.withSecond(3) = " + localTime.withSecond(3));
        //endregion

        //region 判断时间先后
        System.out.println("localTime.isBefore(LocalTime.now()) = " + localTime.isBefore(LocalTime.now()));
        System.out.println("localTime.isAfter(localTime.now()) = " + localTime.isAfter(localTime.now()));
        //endregion
    }
}
