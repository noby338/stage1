package note;

public class IntegerNote {//包装类

    public static void main(String[] args) {
        /*
        把基本数据类型封装为包装类的目的在于用于面向对象
         */
        //region interger
        //region 构造
        Integer integer = new Integer(10);
        new Integer("20");//可传递字符串
        Integer integer10 = 20;
        //endregion

        //region 成员方法
        int i = integer.intValue();//转换为int
        String string1 = integer.toString();

        double v = integer.doubleValue();
        //endregion

        //region 静态方法和属性
        int i1 = Integer.parseInt("123");//字符串转换为int(字符串必须为十进制)
        Integer integer1 = Integer.valueOf("1234");//字符串转Integer
        String string = Integer.toString(321);//int转字符串
        Integer integer2 = Integer.valueOf(1234);//int转Integer

        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);//最大的int数
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.toBinaryString(14) = " + Integer.toBinaryString(14));//转换为二进制
        System.out.println("Integer.toOctalString(14) = " + Integer.toOctalString(14));
        System.out.println("Integer.toHexString(14) = " + Integer.toHexString(14));
        System.out.println("Integer.compare(2,4) = " + Integer.compare(2, 4));//比较，前者大于后者为1，前者小于后者为-1，相等为0
        //endregion
        //endregion

        //region Character
        //region 静态方法
        System.out.println("Character.toLowerCase('A') = " + Character.toLowerCase('A'));
        System.out.println("Character.toUpperCase('b') = " + Character.toUpperCase('b'));
        //endregion
        //endregion

        //region 自动装箱，自动拆箱，只能发生在包装类与其对应的基本数据类型之间
        integer = 23;//自动装箱
        i = integer;//自动拆箱
        //endregion


        //region 面试题
        Integer inte = new Integer(10);
        Integer inte1 = new Integer(10);
        System.out.println("inte == inte1 = " + (inte == inte1));//比较的地址 false
        System.out.println("inte.equals(inte1) = " + inte.equals(inte1));//比较的封装的值 true

        inte = 20;
        inte1 = 20;//自动装箱创建对象，当值相同时，都引用常量池中的已存在的同一个Integer对象
        System.out.println("inte == inte1 = " + (inte == inte1));//比较的地址 true
        System.out.println("inte.equals(inte1) = " + inte.equals(inte1));//比较的封装的值 true

        /*
        Integer为了减少系统的开销，在加载时就会先创建256个Integer对象，这些对象放在常量池中，如果通过
        自动装箱，直接调用Integer.valueof方法，只要数值在[-128,127]之间它会直接得到常量池中的对象，而不会
        重新再创建对象
         */

        inte = 128;
        inte1 = 128;//自动装箱创建的对象值不在 [-128,127] 范围内时，内存池中不存在该 Integer 对象，将通过自己创建 Integer 对象
        System.out.println("inte == inte1 = " + (inte == inte1));//比较的地址 false
        System.out.println("inte.equals(inte1) = " + inte.equals(inte1));//比较的封装的值 true
        // endregion 面试题

    }
}
