package note.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date的使用
 */
public class DateNote {
    public static void main(String[] args) throws ParseException {
        //region 构造函数
        Date date = new Date();//获取当前时间对象
        Date date2 = new Date(System.currentTimeMillis());//通过毫秒值传入参数
        System.out.println("date = " + date);
        //endregion

        //region 成员方法
        System.out.println("new Date().before() = " + new Date().before(date));//之前
        System.out.println("new Date().after(date) = " + new Date().after(date));//之后
        System.out.println("date.getDay() = " + date.getDay());//星期
        System.out.println("date.getTime() = " + date.getTime());//获取当前毫秒值
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        //endregion

        //region 日期格式化器 date转换为字符串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String format = simpleDateFormat.format(date);
        System.out.println("format = " + format);
        //endregion

        //region 字符串转换为日期
        String str = "14:20 星期三";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm E");
        Date date1 = simpleDateFormat1.parse(str);
        System.out.println(date1);
        //endregion
    }
}
