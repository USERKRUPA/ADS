package tree;

import java.util.Scanner;

public class BSTTester {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			
			BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("\na. Insert the data into the binary search tree" + "\nb. Inoder traversal"
							+ "\nc. Preorder traversal" + "\nd. Postoder traversal" + "\nz. exit");
					System.out.println("Enter your choice: ");
					switch (scan.next()) {
					case "a":
						System.out.println("Enter element to insert: ");
						bst.insert(scan.nextInt());
						break;
					case "b":
						System.out.print("Inoder: ");
						bst.inorderTraversal();
						break;
					case "c":
						System.out.print("Preoder: ");
						bst.preorderTraversal();
						break;
					case "d":
						System.out.print("Postoder: ");
						bst.postorderTraversal();
						break;
					case "e": //calculate diameter
						
						break;
					case "f": //find height/depth of tree
						
						break;
					case "g": // bfs
						break;
					case "z":
						exit = true;
						break;
					default:
						System.out.println("Enter valid choice");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
