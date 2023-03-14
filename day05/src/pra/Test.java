package pra;

import java.util.Arrays;

/**
 * @author Noby
 * @since 2023/3/7
 */
public class Test {
    public static void main(String[] args) {

        int a[] = {1, 1};
        a[0] ^= a[0];
        a[0] ^= a[0];
        a[0] ^= a[0];
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));

        fun();
        fun2();
    }

    private static void fun() {
        int[] arr = {2, 1, 3, -1, 6, 5, 7, 9, 8};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minValue = arr[i];
            for (int i1 = i + 1; i1 < arr.length; i1++) {
                if (minValue > arr[i1]) {
                    minValue = arr[i1];
                    minIndex = i1;
                }
            }
            if (i != minIndex) {
                arr[i] ^= arr[minIndex];
                arr[minIndex] ^= arr[i];
                arr[i] ^= arr[minIndex];
            }
        }

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void fun2() {
        int[] arr = {2, -11, 3, 4, 6, 5, 7, 9, 8};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int i1 = 0; i1 < arr.length - i - 1; i1++) {
                if (arr[i1] < arr[i1 + 1]) {
                    arr[i1 + 1] ^= arr[i1];
                    arr[i1] ^= arr[i1 + 1];
                    arr[i1 + 1] ^= arr[i1];
                }
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
