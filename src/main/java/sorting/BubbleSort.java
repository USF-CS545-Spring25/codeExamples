package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void swap(int ind1, int ind2, int[] arr) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }

    public static void bubbleSort(int[] arr) {
        for (int pos = 0; pos < arr.length - 1; pos++) {
        // start at the end and go to pos,
        // bubble the smallest element
        // of the subarray to pos
            for (int j = arr.length - 1; j > pos; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(j, j-1, arr);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 3, 1, 2, 4};
        System.out.println("Before:");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        // bubbleSortPushDownLargest(arr);
        System.out.println("After:");

        System.out.println(Arrays.toString(arr));

    }
}
