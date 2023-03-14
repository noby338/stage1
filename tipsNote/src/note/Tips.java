package note;

import java.util.ResourceBundle;

/**
 * java的使用技巧
 *
 * @author Noby
 * @since 2022/10/3
 */
public class Tips {
    public static void main(String args[]) {
        fn4();
    }

    /**
     * 使用位运算交换两个数
     * <p>
     * 在现代的编译器temp方式调换两个数据的速度和内存都更优，不建议大量使用位运算交换两个数据
     */
    static void fn() {
        int[] nums = {1,2};
        long start = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            nums[0]^=nums[1];
            nums[1]^=nums[0];
            nums[0]^=nums[1];
        }

        //注意避免这种情况的出现
//        nums[0]^=nums[0];
//        nums[0]^=nums[0];
//        nums[0]^=nums[0];

        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("time = " + time);
        System.out.println("nums[0] = " + nums[0]);
        System.out.println("nums[1] = " + nums[1]);
    }

    /**
     * 位运算的尝试
     */
    static void fn2()  {
        short[] sArray = new short[15];
//        Arrays.fill(sArray, Short.MAX_VALUE);
        short temp = 1;
        for (int i = 0; i < sArray.length; i++) {
            sArray[i] = temp;
            temp <<= 1;
        }
        for (short s : sArray) {
            //将数字转换为二进制字符串
            System.out.println(Integer.toBinaryString(s));
        }
    }

    /**
     * 利用ResourceBundle读取类路径下的文件
     */
    static void fn3()  {
        //路径的开始为类路径的根目录，获取的文件可省略扩展名
        ResourceBundle file = ResourceBundle.getBundle("file");
        System.out.println("file.getString(\"info\") = " + file.getString("info"));
    }

    /**
     * 获取字节码文件路径
     */
    static void fn4()  {
        String s = Tips.class.getClassLoader().getResource("").getPath();
        System.out.println("s = " + s);
    }
}
