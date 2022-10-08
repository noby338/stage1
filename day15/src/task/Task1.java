package task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Task1 {
    /*
    1. 将int数组中的数字进行去重：例如int[] nums = {1,2,3,4,5,1,2,1,3,5};
     */
    public static void main(String[] args) {
        int[] nums = {7,2,3,4,5,1,2,1,3,5};
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }
        int[] result = new int[integers.size()];
        Object[] objects = integers.toArray();
        for (int i = 0; i < result.length; i++) {
            result[i] = (int)objects[i];
        }
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
//        Iterator<Integer> iterator = integers.iterator();
//        for (int i = 0; i < result.length; i++) {
//            result[i] = iterator.next();
//        }
//        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }
}
