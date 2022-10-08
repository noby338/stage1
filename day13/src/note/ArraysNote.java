package note;

import java.util.Arrays;

public class ArraysNote {
    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5};
        System.out.println(nums);//打印的为地址值

        //region toString 将数组转换为字符串
        System.out.println(Arrays.toString(nums));
        //endregion

        //region sort 升序排序
        Arrays.sort(nums);//一般搭配comparator对象和comparable接口排序
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        //endregion

        //region copyOf copyOfRange 数组的复制，常用于数组的扩容
        int[] nums1 = Arrays.copyOf(nums,nums.length + 2);//第二参数为拷贝的数组长度(注意：其长度可以大于原数组，常用来给数组扩容)
        System.out.println("Arrays.toString(nums1) = " + Arrays.toString(nums1));

        int[] nums2 = Arrays.copyOfRange(nums,2,8);//表示拷贝的范围，同样的范围可以大于原数组
        System.out.println("Arrays.toString(nums2) = " + Arrays.toString(nums2));
        //endregion
    }
}
