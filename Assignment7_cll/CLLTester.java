//package circularsinglylinkedlist;

import java.util.Scanner;

public class CLLTester {

	public static void main(String[] args) {
		CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>();
		try (Scanner scan = new Scanner(System.in)) {
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("\na. Show the contents of circular linked list"
							+ "\nb. Insert the data at begining of circular linked list"
							+ "\nc. Insert the data at end of circular linked list"
							+ "\nd. Insert the data after given node of circular linked list"
							+ "\ne. Check how many elements are there in the circular linked list"
							+ "\nf. Check to see if circular linked list is empty"
							+ "\ng. Delete first node of circular linked list"
							+ "\nh. Delete last node of circular linked list"
							+ "\ni. Delete given node of circular linked list" 
							+ "\nz. exit");
					System.out.println("Enter your choice: ");
					switch (scan.next()) {
					case "a":
						cll.displayList();
						break;
					case "b":
						System.out.println("Enter value to insert: ");
						cll.insertAtBegin(scan.nextInt());
						//System.out.println("Node inserted...");
						break;
					case "c":
						System.out.println("Enter value to insert: ");
						cll.insertAtEnd(scan.nextInt());
						//System.out.println("Node inserted...");
						break;
					case "d":
						System.out.println("Enter element after which you want to insert: ");
						int element = scan.nextInt();
						System.out.print("Enter data(integer) for new node: ");
						cll.insertAfterGivenNode(scan.nextInt(), element);
						System.out.println("Node inserted...");
						break;
					case "e":
						System.out.println("Total no of nodes: " + cll.countNodes());
						break;
					case "f": // check list empty or not
						System.out.println(cll.isEmpty() ? "Empty" : "Not Empty");
						break;
					case "g": //delete at beginning
						System.out.println("Deleted node is: " +  cll.deleteAtBegin());
						break;
					case "h":
						System.out.println("Deleted node is: " +  cll.deleteAtEnd());
						break;
					case "i":
						System.out.println("Enter node u want to delete: ");
						cll.deleteGivenNode(scan.nextInt());
						System.out.println("Node deleted...");
						break;
					case "z":
						exit = true;
						break;
					default:
						System.out.println("Enter valid choice....");
					}
				} catch (LinkedListException e) {
					System.out.println(e.getMessage());
				}
			}
		} // scan.close();
	}

}
