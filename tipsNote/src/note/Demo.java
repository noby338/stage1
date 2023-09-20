package note;

/**
 * 一个测试类
 *
 * @author Noby
 * @since 2023/5/21 23:39
 */
public class Demo {
    public static void main(String[] args) {
        //选择排序
        //region
        /*
        选择排序的思路：
        1.先从原始数组中找到最小值，将其与原始数组的第一个元素交换位置
        2.再从剩余的元素中找到最小值，将其与原始数组的第二个元素交换位置
        3.重复上述步骤，直到最后一个元素为止
         */
        //endregion
        int[] arr = {1, 3, 2, 5, 4};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//最小值的索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {//找到最小值的索引
                    minIndex = j;
                }
            }
            if (minIndex != i) {//交换
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i : arr) {
            System.out.println("i = " + i);
        }

        //qq邮箱的正则匹配规则
        //region
        /*
        qq邮箱的正则匹配规则：
        1.长度为5-11位
        2.必须以数字开头
        3.只能包含数字、字母、下划线
        4.必须以@qq.com结尾
         */
        //endregion
        String regex = "^[1-9]\\d{4,10}@qq\\.com$";
        String qq = "1326981297@qq.com";
        System.out.println("qq.matches(regex) = " + qq.matches(regex));


        
    }
}

