package minheap;

public class MinHeap {
    private int[] heap; // the array to store the heap
    private int maxsize; // the size of the array
    private int size; // the current number of elements in the array

    /**
     * Constructor for the min heap
     * @param max the maximum size of the heap
     */
    public MinHeap(int max) {
        maxsize = max;
        heap = new int[maxsize];
        size = 0;
        heap[0] = Integer.MIN_VALUE;
        // Note: no actual data is stored at heap[0].
        // Assigned MIN_VALUE so that it's easier to bubble up and easier to compute the index of the parent/children
    }

    /** Return the index of the left child of the element at index pos
     *
     * @param pos the index of the element in the heap array
     * @return the index of the left child
     */
    private int leftChild(int pos) {
        return 2 * pos;
    }

    /** Return the index of the right child
     *
     * @param pos the index of the element in the heap array
     * @return the index of the right child
     */
    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    /** Return the index of the parent
     *
     * @param pos the index of the element in the heap array
     * @return the index of the parent
     */
    private int parent(int pos) {
        return pos / 2;
    }

    /** Returns true if the node in a given position is a leaf
     *
     * @param pos the index of the element in the heap array
     * @return true if the node is a leaf, false otherwise
     */
    private boolean isLeaf(int pos) {
        return ((pos > size / 2) && (pos <= size));
    }

    /** Swap given elements: one at index pos1, another at index pos2
     *
     * @param pos1 the index of the first element in the heap
     * @param pos2 the index of the second element in the heap
     */
    private void swap(int pos1, int pos2) {
        int tmp;
        tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    /** Insert an element into the heap
     *
     * @param elem the element to insert
     */
    public void insert(int elem) {
        size++;
        heap[size] = elem;
        int current = size; // index where we start
        // Bubble up the element as needed, by comparing with the parent
        while(heap[current] < heap[parent(current)]) {
           swap(current, parent(current));
           current = parent(current);
       }
    }

    /** Remove minimum element (it is at the top of the minHeap)
     *
     * @return smallest element in the heap
     */
    public int removeMin() {
        swap(1, size); // swap the end of the heap into the root
        size--;  	   // remove the end of the heap
        // fix the heap
        if (size != 0)
            pushdown(1);
        return heap[size + 1]; // the current smallest element we just deleted is now outside of the heap
    }

    /** Push the value down the heap if it does not satisfy the heap property
     *
     * @param position the index of the element in the heap
     */
    private void pushdown(int position) {
        int smallestChild;
        while (!isLeaf(position)) {
            smallestChild = leftChild(position); // the smallest child is the left one by default
             // check if the right child exists and if it is smaller than the left one
            if (rightChild(position) <= size && heap[rightChild(position)] < heap[smallestChild]) {
                smallestChild = rightChild(position); // the smaller child is the right child
            }
            if (heap[position] <= heap[smallestChild]) { // If the node value is smaller than the value of the smallest child, break
                break;
            }
            swap(position, smallestChild); // bubble down by swapping with the smaller child
            position = smallestChild;
        }
    }

    /** Print the array that stores the heap */
    public void print() {
        int i;
        for (i = 1; i <= size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    /**
     * Build the min heap from the bottom up (in linear time) given an array of n elements
     * @param arr input array
     */
    public void buildBottomUp(int[] arr) {
        if (arr == null)
            return;
        // Place elements from the array to the heap
        for (int i = 0; i < arr.length; i++) {
            heap[i + 1] = arr[i]; // since at index 0 we store Integer.MIN_VALUE, the actual elements should occupy indices 1 to size in the min heap
            size++;
        }
        // Starting from the last internal node in the array and going backwards, push down each internal node
        for(int pos = size / 2;  pos > 0; pos--) {
            pushdown(pos);
        }
    }

    public static void main(String[] args) {
        /*MinHeap minheap = new MinHeap(7);
        minheap.insert(10);
        minheap.insert(2);
        minheap.insert(15);
        minheap.insert(7);
        minheap.insert(1);
        minheap.insert(4);
        minheap.print(); // 1 2 4 10 7 15
       // System.out.println(minheap.removeMin());
       // minheap.print();

         */

        int[] arr = { 8, 6, 14, 5, 3, 11, 15};
        MinHeap newHeap = new MinHeap(8);
        newHeap.buildBottomUp(arr);
        newHeap.print();
    }

}

