package queues;

import stack.ArrayStack;
import stack.Stack;

/** The class that implements the functionality of the queue with
 * two stacks.
 */
public class QueueWithTwoStacks {
    private Stack s1 = new ArrayStack();
    private Stack s2 = new ArrayStack();
    // You may NOT use any other memory, no array and no linked list,
    // only the two stacks, s1, s2. You may call methods push, pop, empty() on s1, s2

    /** Adds an element to the queue
     * @param elem  Element to add to the queue
     */
    public void enqueue(int elem) {
        s1.push(elem);

    }

    /**
     * Removes the element from the queue
     * @return the element in front of the queue that was removed
     */
    public Object dequeue() {
        if (!s2.empty())
            return s2.pop();
        else {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    /**
     * Check if the queue is empty
     * @return True if the queue is empty, and false otherwise.
     */
    public boolean isEmpty() {
        return s1.empty() && s2.empty();
    }
}
