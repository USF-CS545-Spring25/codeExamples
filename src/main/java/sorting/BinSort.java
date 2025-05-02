package sorting;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class BinSort {
    /**
     * Bin sort implementation -  add each element to the linked list
     * for the correct "bin", then use the array of bins to sort arr.
     * @param arr input array of records
     * @param maxValue largest value of the key; all keys are from 0 to maxValue.
     */
    public static void binSort(Elem[] arr, int maxValue) {
        int i;
        // Create bins
        LinkedList<Elem>[] bins = new LinkedList[maxValue + 1];
        // Create an empty linked list for each bin
        for (i = 0; i <= maxValue; i++)
            bins[i] = new LinkedList<Elem>();

        // FILL IN CODE:
        // Iterate over elements of arr, and add each element
        // to the linked list of the correct "bin"
        for (int k = 0; k < arr.length; k++) {
            int binIndex = arr[k].getKey();
            bins[binIndex].addLast(arr[k]);

        }
        // FILL IN CODE: iterate over bins, and place elements from each linked
        // list back into arr
        int count = 0;
        for (int j = 0; j < bins.length; j++) {
            LinkedList<Elem> llist = bins[j];
            Iterator<Elem> it = llist.iterator();
            while (it.hasNext()) {
                Elem elem = it.next();
                arr[count] = elem;
                count++;
            }
        }

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
        binSort(records, 6);
        System.out.println(Arrays.toString(records));
    }

}
