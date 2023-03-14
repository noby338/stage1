package note;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 小数的精确计算
 */
public class BigDecimalNote {
    public static void main(String[] args) {
        //region 基本使用
        double d = 0.1234;
        double d1= 0.245667;
        BigDecimal bigDecimal = new BigDecimal(Double.toString(d));//小数必须填入字符串
        BigDecimal bigDecimal1 = new BigDecimal(d1+"");
        BigDecimal bigDecimal2 = new BigDecimal(10);//整数类型转bigdecimal可以直接填入int
        System.out.println("bigDecimal.add(bigDecimal1) = " + bigDecimal.add(bigDecimal1));
        System.out.println("bigDecimal.subtract(bigDecimal1) = " + bigDecimal.subtract(bigDecimal1));
        System.out.println("bigDecimal.multiply(bigDecimal1) = " + bigDecimal.multiply(bigDecimal1));
        System.out.println("bigDecimal.divide(2) = " + bigDecimal.divide(new BigDecimal(3),2, RoundingMode.HALF_UP));
        //endregion

        //region 数据类型的转换
        System.out.println("bigDecimal2.intValue() = " + bigDecimal2.intValue());
        System.out.println("bigDecimal2.doubleValue() = " + bigDecimal2.doubleValue());
        System.out.println("bigDecimcal2.longValue() = " + bigDecimal2.longValue());
        System.out.println("bigDecimal2.toString() = " + bigDecimal2.toString());
        //endregion

        //region 精度保留
        System.out.println("bigDecimal1.setScale(2) = " + bigDecimal1.setScale(2,BigDecimal.ROUND_HALF_UP));
        //endregion
    }
}
