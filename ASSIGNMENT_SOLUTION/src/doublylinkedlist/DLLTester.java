package doublylinkedlist;

import java.util.Scanner;

public class DLLTester {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		try (Scanner scan = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("\na. Show the contents of doubly linked list"
							+ "\nb. Insert the data at begining of doubly linked list"
							+ "\nc. Insert the data at end of doubly linked list"
							+ "\nd. Insert the data after given node of doubly linked list"
							+ "\ne. Check how many elements are there in the doubly linked list"
							+ "\nf. Check to see if doubly linked list is empty" + "\nz. exit");
					System.out.println("Enter your choice: ");
					switch (scan.next()) {
					case "a":
						dll.display();
						break;
					case "b":
						System.out.println("Enter value to insert: ");
						dll.insertAtBegin(scan.nextInt());
						System.out.println("Node inserted...");
						break;
					case "c":
						System.out.println("Enter value to insert: ");
						dll.insertAtEnd(scan.nextInt());
						System.out.println("Node inserted...");
						break;
					case "d":
						System.out.println("Enter element after which you want to insert: ");
						int element = scan.nextInt();
						System.out.print("Enter data(integer) for new node: ");
						dll.insertAtGivenNode(scan.nextInt(), element);
						System.out.println("Node inserted...");
						break;
					case "e":
						System.out.println("Total no of nodes: " + dll.countNodes());
						break;
					case "f": // check list empty or not
						System.out.println(dll.isEmpty() ? "Empty" : "Not Empty");
						break;
					case "g": //delete at begining
						System.out.println("Deleted node is: " +  dll.deleteAtBegin());
						break;
					case "h":
						System.out.println("Deleted node is: " +  dll.deleteAtEnd());
						break;
					case "i":
						System.out.println("Enter node u want to delete: ");
						dll.deleteGivenNode(scan.nextInt());
						break;
					case "z":
						exit = true;
						break;
					default:
						System.out.println("Enter valid choice....");
					}
				} catch (EmptyLinkedListException e) {
					System.out.println(e.getMessage());
				}
			}
		} // scan.close();
	}

}
