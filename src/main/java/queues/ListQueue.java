package queues;
/** Implementation of Queue ADT using a singly linked list. 
 *  This implementation does not use a dummy node. */
public class ListQueue implements Queue {
	private Node head;
	private Node tail;

	ListQueue() {
		head = null;
		tail = null;
	}

	/**
	 * Create a new node with elem and add it to the
	 * end of the linked list
	 * @param elem element to add to the queue
	 */
	public void enqueue(Object elem) {
		if (head == null) {
			head = new Node(elem);
			tail = head;
		} else {
			tail.setNext(new Node(elem));
			tail = tail.next();
		}
	}

	/**
	 * Remove the first element from the queue
	 * (and return its value)
	 * @return the first element in the queue
	 */
	public Object dequeue() {
		Object dequeuedElem;

		//if (head == null)
		//	return null;
		if (empty()) {
			System.out.println("No elements in the queue");
			return null;
		}
		dequeuedElem = head.getElem();
		head = head.next();
		if (head == null)
			tail = null;
		return dequeuedElem;
	}

	/** Return true if the queue has no elements */
	public boolean empty() {
		return (head == null);
	}

	/** Return a string represeting a queue */
	public String toString() {
		String result = "[";
		Node tmp = head;
		if (tmp != null) {
			result = result + tmp.getElem();
			tmp = tmp.next();
			while (tmp != null) {
				result = result + "," + tmp.getElem();
				tmp = tmp.next();
			}
		}
		result = result + "]";
		return result;
	}

}
