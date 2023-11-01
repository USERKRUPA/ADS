package stack;

import java.util.Scanner;

public class StackTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter stack size: ");

		// create a stack of user input size
		Stack stack = new Stack(sc.nextInt());

		boolean exit = false;
		while (!exit) {
			System.out.println("\n0. Exit\n1. Display the stack\n2. Push the data on the stack"
					+ "\n3. Pop the data from the stack" + "\n4. Check how many elements are there on the stack"
					+ "\n5. Check to see if the stack is full" + "\n6. Check to see if stack is empty");
			System.out.println("Enter your choice: ");
			switch (sc.nextInt()) {
			case 1:
				stack.display();
				break;
			case 2:
				System.out.println("Enter element to insert in stack: ");
				stack.push(sc.nextInt());
				break;
			case 3:
				System.out.println("Element deleted from stack is: " + stack.pop());
				break;
			case 4:
				System.out.println("No of elements in stack: " + stack.countElements());
				break;
			case 5:
				System.out.println(stack.isFull()?"Full":"Not full");
				break;
			case 6:
				System.out.println(stack.isEmpty()?"Empty":"Not empty");
				break;
			case 0:
				exit = true;
				break;
			}
		}
		sc.close();
	}

}
