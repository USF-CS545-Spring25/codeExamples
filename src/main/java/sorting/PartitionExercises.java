package sorting;

import java.util.Arrays;

public class PartitionExercises {

    /**
     * Sort an array of 0s and 1s in one pass and in linear time
     * using the algorithm discussed during the leccture
     * @param arr input array of 0s and 1s
     */
    public static void sort01(int[] arr) {
        int i = 0; // starts at the beginning
        int j = arr.length - 1; // starts at the end
        while (i < j) {
           while(i < j && arr[i] == 0) {
               i++;
           }
           while(i < j && arr[j] == 1) {
               j--;
           }
           if (i < j) { // swap
               arr[i] = 0;
               arr[j] = 1;
           }
       }

    }

    /**
     * Pick the middle element of the array as the pivot.
     * Partition the input array (in linear time, in one pass) so that elements on the left of the pivot are smaller than the pivot,
     * and elements on the right side of the pivot are >= pivot
     * @param arr input array
     * @return index of the pivot (after the partition)
     */
    public static int partitionArray(int[] arr) {
        int n = arr.length;
        int midIndex = n / 2;
        int pivotElement = arr[midIndex];
        int i = 0;
        int j = n - 2;
        arr[midIndex] = arr[n - 1];
        arr[n - 1] = pivotElement;

        while (i <= j) {
            while(i <= j && arr[i] < pivotElement) {
                i++;
            }
            while(i <= j && arr[j] >= pivotElement) {
                j--;
            }
            if (i < j) { // swap
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        int tmp = arr[i];
        arr[i] = pivotElement;
        arr[arr.length - 1] = tmp;

        return i; // should return the index of the pivot
    }

    /** Partition a subarray from index low to index high (inclusive)
     *
     * @param arr input array
     * @param low starting index of the subarray
     * @param high end index of the subarray
     * @return index of the pivot after the partition
     */
    private static int partitionSubarray(int arr[], int low, int high) {
        int pivot;
        int mid = (low + high) / 2;
        int pivotElement = arr[mid];
        System.out.println("Pivot = " + pivotElement);

        int i = low;
        int j = high - 1;
        // swap the pivot out of the way (store it at index high)
        arr[mid] = arr[high];
        arr[high] = pivotElement;

        while (i <= j) {
            while(i <= j && arr[i] < pivotElement) {
                i++;
            }
            while(i <= j && arr[j] >= pivotElement) {
                j--;
            }
            if (i < j) { // swap
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        // swap the pivot into index i
        int tmp = arr[i];
        arr[i] = pivotElement;
        arr[high] = tmp;

        return i; // returning the index of the pivotElement
    }


    public static void main(String[] args) {

        int[] arr1 = {0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1};
        System.out.println("Before sort01: ");
        System.out.println(Arrays.toString(arr1));
        sort01(arr1);
        System.out.println("After sort01: ");
        System.out.println(Arrays.toString(arr1));

        System.out.println();
        System.out.println("Testing partitionArray");
        int[] arr2 = {5, 9, 0, 1, 12, 6, 20, 4, 10, 3, 45};
        System.out.println("Before partitioning by " + arr2[(arr2.length - 1)/2]);
        System.out.println(Arrays.toString(arr2));
        partitionArray(arr2); // 6 is the pivot in this example
        System.out.println("After partitioning by " + arr2[arr2.length / 2] + ": ");
        System.out.println(Arrays.toString(arr2));

        // Uncomment to test partitionSubarray
        int[] arr3 = {5, 9, 0, 1, 12, 6, 20, 4, 10, 3, 45};
        System.out.println();
        System.out.println("Testing partitionSubArray");
        System.out.println("Before partitioning from [2, 10] using pivot " + arr3[6]);
        System.out.println(Arrays.toString(arr3));
        partitionSubarray(arr3, 2, arr3.length - 1);
        System.out.println("After partitioning from [2, 10]");
        System.out.println(Arrays.toString(arr3));
        // TODO: test with different low, high


    }
}

