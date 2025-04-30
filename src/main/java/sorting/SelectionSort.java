package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void swap(int ind1, int ind2, int[] arr) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexOfMin = i;
            //search for min from index = i to length
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            // swap it into index i
            swap(i, indexOfMin, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 3, 1, 2, 4};
        System.out.println("Before:");
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After:");

        System.out.println(Arrays.toString(arr));

    }
}
