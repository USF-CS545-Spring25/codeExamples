package linkedlists;

import java.util.Iterator;

/** A class representing a singly linked list. */
public class LinkedList  implements  Iterable<Node> {
	private Node head, tail;

	/** Constructor */
	public LinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Creates a new node with the given element and adds it to the back of the
	 * list
	 */
	public void append(int elem) {
		Node newNode = new Node(elem);
		if (tail != null) {
			tail.setNext(newNode);
			tail = newNode;
		} else { // if it's an empty list
			head = tail = newNode;
		}
	}

	/** Prints all the nodes in the link list */
	public void printNodes() {
		Node current = head;
		while (current != null) {
			System.out.print(current.getElem() + " ");
			current = current.next();
		}
		System.out.println();
	}

	/**
	 * Insert a new node with the given element in front of the linked list
	 * @param elem element
	 */
	public void insertAtFront(int elem) {
		// Insert a new node with elem in front of the linked list
		Node newNode = new Node(elem);
		if (head == null) {
			head = tail = newNode;
		}
		else {
			newNode.setNext(head);
			head = newNode;
		}
	}

	/**
	 * Insert a new node with the given element at index i
	 * @param i index
	 * @param elem element
	 */
	public void insertAtIndex(int i, int elem) {
		// Iinsert a new node with the given elem
		// at "index" i
		// Example:
		// If the linked list is 5 -> 7 - > 2 and we call
		// insertAtIndex(1, 8), the linked list will be
		// 5 -> 8 -> 7 -> 2  we inserted element 8 at "index" = 1.

		if (head == null)
			return; // nothing to do
		if (i == 0) {
			insertAtFront(elem);
		}
		else {
			Node current = head;
			int count = 0;
			while (current != null && count < i - 1) {
				current = current.next();
				count+= 1;
			}
			if (current == null)
				return; // no such index
			Node newNode = new Node(elem);
			if (current == tail)
				tail = newNode;
			newNode.setNext(current.next());
			current.setNext(newNode);
		}

	}

	/** Remove a node after the prevNode
	 *
	 * @param prevNode node before the one we need to remove
	 */
	public void removeNodeAfter(Node prevNode) {
		if (head == null || prevNode == null || prevNode.next() == null)
			return; // nothing to do since no node after prevNode

		if (prevNode.next() == tail)
			tail = prevNode;
		prevNode.setNext(prevNode.next().next());
	}

	/** Get the element at the node at "index" k from the end of the list
	 *
	 * @param k index from the end of the linked list
	 * @return element at that index
	 */
	public int getNodeAtIndexKFromEnd(int k) {
		Node slow = head;
		Node fast = head;
		int count = 0;
		while (fast != null && count < k) {
			fast = fast.next();
			count++;
		}
		if (fast == null) {
			System.out.println("No such index");
			return Integer.MAX_VALUE;
		}

		while (fast != tail) {
			slow = slow.next();
			fast = fast.next();
		}

		return slow.getElem();
	}


	/**
	 * Return the head of the linked list
	 * @return head
	 */
	public Node head() {
		return head;
	}

	/** Returns the tail
	 *
	 * @return tail
	 */
	public Node tail() {
		// Useful for testing
		return tail;
	}

	@Override
	public Iterator<Node> iterator() {
		return new MyLinkedListIterator();
	}

	// An inner class implementing Iterator
	public class MyLinkedListIterator implements Iterator<Node> {
		private Node current;

		public MyLinkedListIterator() {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Node next() {
			Node nextNode = current;
			current = current.next();
			return nextNode;
		}
	}

}
