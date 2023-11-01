package assignment5;

import java.util.Scanner;

public class LinkedListTester {

	public static void main(String[] args) {
		LinkedList singlyLinkedList = new LinkedList();
		Scanner scan = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("\na. Show the contents of linked list" 
					+ "\nb. Insert the data at begining of the linked list"
					+ "\nc. Insert the data at end of the linked list"
					+ "\nd. Insert the data after given node in the linked list"
					+ "\ne. Delete begining node"
					+ "\nf. Delete at end"
					+ "\ng. Delete given node"
					+ "\nh. Check how many elements are there in the linked list"
					+ "\ni. Check to see if linked list is empty" 
					+ "\nz. Exit");
			System.out.println("Enter your choice: ");
			switch (scan.next()) {
			case "a": //display list
				System.out.println("---------Linked list---------");
				singlyLinkedList.display();
				break;
			case "b": //insert at beginning
				System.out.print("Enter data(integer) for new node: ");
				singlyLinkedList.insertAtBegin(scan.nextInt());
				System.out.println("\nNode inserted...");
				break;
			case "c": //insert at end
				System.out.print("Enter data(integer) for new node: ");
				singlyLinkedList.insertAtEnd(scan.nextInt());
				System.out.println("\nNode inserted...");
				break;
			case "d"://insert after given node
				System.out.println("Enter element after which you want to insert: ");
				int element = scan.nextInt();
				System.out.print("Enter data(integer) for new node: ");
				singlyLinkedList.insertAfterGivenNode(scan.nextInt(), element);
				System.out.println("\nNode inserted...");
				break;
			case "e":
				System.out.println("Node deleted is: " + singlyLinkedList.deleteAtBegin());
				break;
			case "f":
				System.out.println("Node deleted is: " + singlyLinkedList.deleteAtEnd());
				break;
			case "g":
				System.out.println("Enter element u want to delete");
				singlyLinkedList.deleteGivenNode(scan.nextInt());
				break;
			case "h": //count no of nodes
				System.out.println("Total no of nodes: " + singlyLinkedList.countNodes());
				break;
			case "i": //check list empty or not 
				System.out.println(singlyLinkedList.isEmpty() ? "Empty" : "Not Empty");
				break;
			case "z":
				exit = true;
				break;
			default:
				System.out.println("Enter valid choice");
			}
		}
		scan.close();
	}

}
