//package linear_queue;

import java.util.Scanner;

public class QueueTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter queue size: ");

		// create a queue of user input size
		Queue queue = new Queue(sc.nextInt());

		boolean exit = false;
		while (!exit) {
			System.out.println("\n0. Exit\n1. Show the queue\n2. Store the data in the queue"
					+ "\n3. Access the data from the queue" + "\n4. Check how many elements are there in the queue"
					+ "\n5. Check to see if the queue is full?" + "\n6. Check to see if queue is empty");
			System.out.println("Enter your choice: ");
			switch (sc.nextInt()) {
			case 1:
				queue.display();
				break;
			case 2:
				System.out.println("Enter element to insert in queue: ");
				queue.enqueue(sc.nextInt());
				break;
			case 3:
				System.out.println("Data on front of queue is: " + queue.dequeue());
				break;
			case 4:
				System.out.println("No of elements in queue: " + queue.countElements());
				break;
			case 5:
				System.out.println(queue.isFull() ? "Full" : "Not full");
				break;
			case 6:
				System.out.println(queue.isEmpty() ? "Empty" : "Not empty");
				break;
			case 0:
				exit = true;
				break;
			}
		}
		sc.close();
	}

}
