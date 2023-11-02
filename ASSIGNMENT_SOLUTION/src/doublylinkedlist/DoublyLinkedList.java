package doublylinkedlist;

public class DoublyLinkedList<T> {
	private Node<T> head;

	private static class Node<T> {
		private T data;
		private Node<T> next;
		private Node<T> prev;

		Node(T data) {
			this.data = data;
			this.setNext(null);
			this.setPrev(null);
		}

		void setNext(Node<T> next) {
			this.next = next;
		}

		void setPrev(Node<T> prev) {
			this.prev = prev;
		}

		T getData() {
			return this.data;
		}

		Node<T> getNext() {
			return this.next;
		}

		Node<T> getPrev() {
			return this.prev;
		}

		@Override
		public String toString() {
			return data + " <--> ";
		}
	}

	public DoublyLinkedList() {
		this.head = null;
	}

	public void insertAtBegin(T value) {
		Node<T> nwNode = new Node<>(value);
		if (head == null) {
			head = nwNode;
			return;
		}
		nwNode.setNext(head);
		head.setPrev(nwNode);
		head = nwNode;
	}

	public void insertAtEnd(T value) {
		Node<T> nwNode = new Node<>(value);
		if (head == null) {
			head = nwNode;
			return;
		}
		Node<T> currNode;
		for (currNode = head; currNode.getNext() != null; currNode = currNode.getNext())
			;
		currNode.setNext(nwNode);
		nwNode.setPrev(currNode);
	}

	public void insertAtGivenNode(T value, T element) throws EmptyLinkedListException {
		Node<T> nwNode = new Node<>(value);
		if (head == null) {
			throw new EmptyLinkedListException("List is empty...");
		}

		Node<T> currNode;
		for (currNode = head; currNode != null; currNode = currNode.getNext()) {

			if (currNode.getData() == element && currNode.getNext() != null) {
				nwNode.setNext(currNode.getNext());
				nwNode.setPrev(currNode);
				currNode.getNext().setPrev(nwNode);
				currNode.setNext(nwNode);
				return;
			}
			if (currNode.getData() == element && currNode.getNext() == null) {
				currNode.setNext(nwNode);
				nwNode.setPrev(currNode);
				return;
			}
		}
		throw new EmptyLinkedListException("No such element available in the DLL...");
	}

	public void display() throws EmptyLinkedListException {
		if (isEmpty())
			throw new EmptyLinkedListException("Linked list is empty...");
		Node<T> currNode;
		System.out.println("--------DDL--------");
		for (currNode = head; currNode != null; currNode = currNode.getNext()) {
			System.out.print(currNode); // calls currNode.toString()
		}
		System.out.println(" null");
	}

	public int countNodes() {
		int counter = 0;
		Node<T> currNode;

		for (currNode = head; currNode != null; currNode = currNode.getNext()) {
			counter++;
		}
		return counter;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public T deleteAtBegin() throws EmptyLinkedListException {
		if (isEmpty())
			throw new EmptyLinkedListException("List is empty...");
		T element = head.getData();
		if (head.getNext() == null) {
			head = null;
		} else {
			head = head.getNext();
			head.setPrev(null);
		}
		return element;
	}

	public T deleteAtEnd() throws EmptyLinkedListException {
		if (isEmpty())
			throw new EmptyLinkedListException("List is empty...");
		Node<T> currNode;
		for (currNode = head; currNode.getNext() != null; currNode = currNode.getNext()) {

		}
		T element = currNode.getData();
		if (head.getNext() == null) {
			head = null;
		} else {
			currNode.getPrev().setNext(null);
			currNode.setPrev(null);// optional
		}
		return element;
	}

	public void deleteGivenNode(T element) throws EmptyLinkedListException {
		if (isEmpty())
			throw new EmptyLinkedListException("List is Empty...");
		if (head.getData() == element) {
			// delete at beginning
			if (head.getNext() == null)
				head = null;
			else {
				head = head.getNext();
				head.setPrev(null);
			}
			System.out.println("Element deleted...");
			return;
		} else {
			// element is in between
			Node<T> currNode;
			for (currNode = head; currNode != null; currNode = currNode.getNext()) {
				if (currNode.getData() == element) {
					if (currNode.getNext() != null) {
						currNode.getNext().setPrev(currNode.getPrev());
						currNode.getPrev().setNext(currNode.getNext());
					} else {
						currNode.getPrev().setNext(null);
						currNode.setPrev(null);// optional
					}
					System.out.println("Element deleted...");
					return;
				}
			}
			throw new EmptyLinkedListException("No such element found in the list...");
		}

	}

}
