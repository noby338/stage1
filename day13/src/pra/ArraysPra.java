package pra;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraysPra {
    public static void main(String[] args) {
        int[] nums = {22,11,33,44};
        System.out.println("nums.length = " + nums.length);
        int[] nums1 = Arrays.copyOf(nums, 3);
        System.out.println("Arrays.toString(nums1) = " + Arrays.toString(nums1));
        int[] nums2 = Arrays.copyOfRange(nums, 1, 3);
        System.out.println("Arrays.toString(nums2) = " + Arrays.toString(nums2));
        Arrays.sort(nums);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }
}
