package linkedlists;

import java.util.Iterator;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(7);
        list.append(25);
        list.append(50);
        list.append(55);
        list.append(80);
        list.append(100);
        list.append(155);
        list.printNodes();

        Iterator<Node> it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        list.insertAtIndex(3, 45);
        list.printNodes();
        System.out.println("tail = " + list.tail().getElem());

        list.removeNodeAfter(list.head());
        System.out.println("After removing the node after the head");
        list.printNodes();

        System.out.println("The element at the node at index 1 from the end: ");
        System.out.println(list.getNodeAtIndexKFromEnd(1));

    }
}
