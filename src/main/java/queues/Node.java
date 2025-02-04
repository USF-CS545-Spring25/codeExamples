package queues;

//--------------------- Class Node -------------------------
/** Defines a single node in the LinkedList */
public class Node {
    private Object element;
    private Node next;

    public Node(Object newElement) {
        element = newElement;
        next = null;
    }

    /**
     * Create a new linked list node, where the data in the node is
     * newElement, and the "next" points at newNext
     *
     * @param newElement element
     * @param newNext pointer to the next node
     */
    public Node(Object newElement, Node newNext) {
        element = newElement;
        next = newNext;
    }

    /**
     * Return the next node
     * @return next node
     */
    public Node next() {
        return next;
    }

    /**
     * Return the element stored in the node
     * @return element
     */
    public Object getElem() {
        return element;
    }


    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

}
