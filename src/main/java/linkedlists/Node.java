package linkedlists;

/* A class representing a node in a singly linked list */
public class Node {
	private int elem;
	private Node next;
	
	public Node(int elem, Node next) {
		this.elem = elem;
		this.next  = next;
	}
	
	public Node(int elem) {
		this.elem = elem;
		next = null;
	}
	
	public int getElem() {
		return elem;
	}
	
	public void setElem(int elem) {
		this.elem = elem;
	}
	
	public Node next() {
		return next;
	}
	
	public void setNext(Node other) {
		next = other;
	}

	@Override
	public String toString() {
		return elem + ", ";
	}
}
