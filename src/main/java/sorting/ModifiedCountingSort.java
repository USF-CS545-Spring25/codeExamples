package sorting;
import java.util.Arrays;

public class ModifiedCountingSort {

    /**
         * Implementation of the modified counting sort
         * @param arr input array
         * @param maxValue largest possible value that can occur in the array.
         * Assume the range of elements is from 0 to maxValue, inclusive.
         */
        public static void modifiedCountingSort(Elem[] arr, int maxValue) {
            int[] counterArray = new int[maxValue + 1];
            for (int i = 0; i < arr.length; i++) {
                counterArray[arr[i].getKey()]++;
            }

            // Modify the counter array c[j] = c[j] + c[j-1]
            for (int j = 1; j < counterArray.length; j++)
                counterArray[j] = counterArray[j] + counterArray[j-1];

            Elem[] result = new Elem[arr.length];
            for (int k = arr.length - 1; k >= 0; k--) {
                // Iterate over the input array and using the counter array, place elements back into arr
                counterArray[arr[k].getKey()]--;
                result[counterArray[arr[k].getKey()]] = arr[k];
            }

            // Copy elements from the array "result" back to arr
            for (int k = 0; k < result.length; k++)
                arr[k] = result[k];

        }

        public static void main(String[] args) {
            Elem[] records = {
                    new Elem(6, "red"),
                    new Elem(1, "blue"),
                    new Elem(6, "yellow"),
                    new Elem(2, "black"),
                    new Elem(1, "brown"),
                    new Elem(6, "orange"),
                    new Elem(0, "green"),
                    new Elem(6, "gray")};
            modifiedCountingSort(records, 6);
            System.out.println(Arrays.toString(records));
        }

}
