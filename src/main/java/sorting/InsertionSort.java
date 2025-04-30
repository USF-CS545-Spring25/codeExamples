package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int curr;
        int j;
        for (int i = 1; i < arr.length; i++) { // goes through unsorted part of the array
            curr = arr[i]; // we will  insert it into the sorted part of the array
            // insert curr into the sorted part of the list
            j = i - 1; // last element in the sorted part
            while (j >= 0 && curr < arr[j]) { // should  go through the sorted part of the array and do the comparison and sliding
                // this is where I shift // "slide" arr[j] to the right
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;

        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 3, 1, 2, 4, 9, 15, 67, 89, 49, 4, 2, 0};
        System.out.println("Before:");
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After:");
        System.out.println(Arrays.toString(arr));
    }
}
