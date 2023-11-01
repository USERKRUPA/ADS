package assignment5;

//template for node in singly linked list
class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {
	private Node head;

	public LinkedList() {
		head = null;
	}

	// Show the contents of linked list
	public void display() {
		if (isEmpty()) {
			System.out.println("Linked List is empty...");
			return;
		}
		for (Node currentNode = head; currentNode != null; currentNode = currentNode.next) {
			System.out.print(currentNode.data + " --> ");
		}
		System.out.println("null");
	}

	public void insertAtBegin(int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
	}

	public void insertAtEnd(int val) {
		Node newNode = new Node(val);
		if (isEmpty())
			head = newNode;
		else {
			Node currentNode;
			for (currentNode = head; currentNode.next != null; currentNode = currentNode.next)
				;
			currentNode.next = newNode;
		}
	}

	public void insertAfterGivenNode(int val, int element) {
		Node newNode = new Node(val);
		if (isEmpty())
			head = newNode;
		else {
			Node currentNode;
			for (currentNode = head; currentNode.next != null; currentNode = currentNode.next) {
				if (currentNode.data == element) {
					newNode.next = currentNode.next;
					currentNode.next = newNode;
					return;
				}
			}
			insertAtEnd(val);
		}
	}

	public int deleteAtBegin() {
		if (isEmpty()) {
			System.out.println("Empty list...");
			return -1;
		}
		int data = head.data;
		head = head.next;
		return data;
	}
	
	public int deleteAtEnd() {
		if (isEmpty()) {
			System.out.println("Empty list...");
			return -1;
		}
		Node currentNode, prevNode = null;
		for (currentNode = head; currentNode.next != null; currentNode = currentNode.next) {
			prevNode = currentNode;
		}
		int data = currentNode.data;
		prevNode.next = currentNode.next;
		return data;
	}
	
	public void deleteGivenNode(int element) {
		if (isEmpty()) {
			System.out.println("Empty list...");
			return;
		}
		if(head.data == element) {
			deleteAtBegin();
			return;
		}
		Node currentNode, prevNode = null;
		for (currentNode = head; currentNode.next != null; currentNode = currentNode.next) {
			if(currentNode.data == element) {
				prevNode.next = currentNode.next;
				return;
			}
			prevNode = currentNode;
		}
		System.out.println("No such element exist...");
	}
	
	public boolean isEmpty() {
		return head == null;
	}

	public int countNodes() {
		int count = 0;
		for (Node currentNode = head; currentNode != null; currentNode = currentNode.next) {
			count++;
		}
		return count;
	}

}
