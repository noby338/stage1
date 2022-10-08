package pra;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class LocalDateTimePra {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDate birthday = LocalDate.of(1999, 3, 11);
        System.out.println(birthday);
        System.out.println("我的生日是：" + birthday.getMonthValue() + "月" + birthday.getDayOfMonth() + "日");

        String str = "12分44秒";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH分mm秒");
        LocalTime parse = LocalTime.parse(str, dateTimeFormatter);
        System.out.println(parse);
    }
}
