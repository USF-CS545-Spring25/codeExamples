package sorting;

import java.util.Arrays;

public class MergingTwoSortedArrays {
    /**
     *  Efficiently merge two sorted arrays together (in linear time) into one sorted array
     *  in increasing order.
     * @param arr1 sorted array 1 in increasing order
     * @param arr2 sorted array 2 in increasing order
     * @return sorted array in increasing order that contains elements from both arr1 and arr2
     */
    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i = 0; // index for arr1
        int j = 0; // index for arr2
        int k = 0; // index for res
        while (k < arr1.length + arr2.length) {
            // handle the case when arr1 has no elements, but arr2 has
            if (i >= arr1.length) {
                res[k] = arr2[j];
                j++;
            }
            else if (j >= arr2.length){   // handle the case when arr2 has no elements, but arr1 has

                res[k] = arr1[i];
                i++;
            }
            else {
                if (arr1[i] <= arr2[j]) {  // handle the case when both arr1 and arr2 have elements

                    res[k] = arr1[i];
                    i++;
                }
                else {
                    res[k] = arr2[j];
                    j++;
                }
            }
            k++;

        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 8};
        int[] arr2 = {2, 3, 7, 10, 15};
        int[] res = mergeTwoSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(res)); // 1, 2, 3, 5, 7, 8, 10, 15

    }
}
