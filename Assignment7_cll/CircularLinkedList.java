//package circularsinglylinkedlist;

public class CircularLinkedList<T> {
	private Node<T> head;

	private static class Node<T> {
		private T data;
		private Node<T> next;

		Node(T data) {
			this.data = data;
			this.setNext(null);
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public T getData() {
			return data;
		}

		@Override
		public String toString() {
			return data + " --> ";
		}

	}

	public CircularLinkedList() {
		super();
		this.head = null;
	}

	public void insertAtBegin(T value) {
		Node<T> nwNode = new Node<>(value);
		if (isEmpty()) {
			head = nwNode;
			head.setNext(head);
		} else {
			Node<T> currNode;
			for (currNode = head; currNode.getNext() != head; currNode = currNode.getNext())
				;
			currNode.setNext(nwNode);
			nwNode.setNext(head);
			head = nwNode;
		}
		System.out.println("Node inserted");
	}

	public void insertAtEnd(T value) {
		Node<T> nwNode = new Node<>(value);
		if (isEmpty()) {
			head = nwNode;
			nwNode.setNext(head);
		} else {
			Node<T> currNode;
			for (currNode = head; currNode.getNext() != head; currNode = currNode.getNext())
				;
			currNode.setNext(nwNode);
			nwNode.setNext(head);
		}
		System.out.println("Node inserted");
	}

	public void insertAfterGivenNode(T value, T element) throws LinkedListException {
		Node<T> nwNode = new Node<>(value);
		if (isEmpty()) {
			throw new LinkedListException("List is empty");
		}
		if (head.getData() == element && head.getNext() == head) {
			nwNode.setNext(head);
			head.setNext(nwNode);
			return;
		}
		Node<T> currNode;
		for (currNode = head; currNode.getNext() != head; currNode = currNode.getNext()) {
			//System.out.println("inside loop");
			if (currNode.getData() == element) {
				//System.out.println("inside if");
				nwNode.setNext(currNode.getNext());
				currNode.setNext(nwNode);
				return;
			}
		}
		// last element match

		if (currNode.getData() == element) {
			nwNode.setNext(head);
			currNode.setNext(nwNode);
			return;
		}

		throw new LinkedListException("No such element found...");
	}

	public void displayList() throws LinkedListException {
		if (isEmpty()) {
			throw new LinkedListException("List is empty...");
		}
		Node<T> currNode;
		for (currNode = head; currNode.getNext() != head; currNode = currNode.getNext())
			System.out.print(currNode);
		System.out.println(currNode + " head ");
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void deleteGivenNode(T element) throws LinkedListException {
		if (isEmpty())
			throw new LinkedListException("List is empty");

		if (head.getData() == element) {
			deleteAtBegin();
			return;
		}

		Node<T> currNode, prevNode = head;
		for (currNode = head.getNext(); currNode != head; currNode = currNode.getNext()) {

			if (currNode.getData() == element && currNode.getNext() != null) {
				prevNode.setNext(currNode.getNext());
				return;
			}
			if (currNode.getData() == element && currNode.getNext() == null) {
				prevNode.setNext(head);
				return;
			}
			prevNode = currNode;
		}
		throw new LinkedListException("No such element found");
	}

	public T deleteAtEnd() throws LinkedListException {
		if (isEmpty())
			throw new LinkedListException("List is empty");
		T element = null;
		if (head.getNext() == head) {
			element = head.getData();
			head = null;
		} else {
			Node<T> currNode, prevNode = null;
			for (currNode = head; currNode.getNext() != head; currNode = currNode.getNext())
				prevNode = currNode;
			element = currNode.getData();
			prevNode.setNext(head);
		}
		return element;
	}

	public T deleteAtBegin() throws LinkedListException {
		if (isEmpty())
			throw new LinkedListException("List is empty");
		T element = head.getData();
		if (head.getNext() == head)
			head = null;
		else {
			Node<T> currNode;
			for (currNode = head; currNode.getNext() != head; currNode = currNode.getNext())
				;
			head = head.getNext();
			currNode.setNext(currNode.getNext().getNext());
		}
		return element;
	}

	public int countNodes() throws LinkedListException {
		if (isEmpty()) {
			throw new LinkedListException("List is empty...");
		}
		int counter = 0;
		Node<T> currNode;
		for (currNode = head; currNode.getNext() != head; currNode = currNode.getNext())
			counter++;
		return ++counter;
	}
}
