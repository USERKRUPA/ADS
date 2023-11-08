//package circular_queue;

import java.util.Scanner;

public class CircularQueueTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter circular queue size: ");

		// create a circular queue of user input size
		CircularQueue cQueue = new CircularQueue(sc.nextInt());

		boolean exit = false;
		while (!exit) {
			System.out.println(
					"\n0. Exit\n1. Show the contents of circular queue\n2. Enqueue the data in the circular queue"
							+ "\n3. Access the data from the circular queue"
							+ "\n4. Check how many elements are there in the circular queue."
							+ "\n5. Check to see if the circular queue is full"
							+ "\n6. Check to see if circular queue is empty");
			System.out.println("Enter your choice: ");
			switch (sc.nextInt()) {
			case 1:
				cQueue.display();
				break;
			case 2:
				System.out.println("Enter element to insert in circular queue: ");
				cQueue.enqueue(sc.nextInt());
				break;
			case 3:
				System.out.println("Element accessed is: " + cQueue.dequeue());
				break;
			case 4:
				System.out.println("No of elements: " + cQueue.countElements());
				break;
			case 5:
				System.out.println(cQueue.isFull() ? "Full" : "Not full");
				break;
			case 6:
				System.out.println(cQueue.isEmpty() ? "Empty" : "Not empty");
				break;
			case 0:
				exit = true;
				break;
			}
		}
		sc.close();
	}

}
