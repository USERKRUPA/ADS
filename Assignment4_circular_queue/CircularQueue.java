//package circular_queue;

public class CircularQueue {
	private int rear;
	private int front;
	private int[] data;
	 
	public CircularQueue(int size) {
		rear = front = -1;
		data = new int[size];
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Circular Queue is Empty...");
			return;
		}
		int i;
		System.out.println("Circular Queue contents: ");
		for(i = front; i != rear ; i= (i+1)%data.length)
			System.out.print(data[i] + ", ");
		System.out.println(data[i]);
	}
	
	public void enqueue(int element) {
		if(isFull()) {
			System.out.println("Circular Queue is Full...");
			return;
		}
		rear = (rear + 1) % data.length;
		data[rear] = element;
		if(front == -1) 	
			front = 0;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Circular Queue is Empty...");
			return -1;
		}
		int element = data[front];
		if(front == rear)
			front = rear = -1;
		else
			front = (front + 1) % data.length;
		return element;
	}
	
	public int countElements() {
		int count = 1;
		if(isEmpty())
			count = 0;
		for(int i = front; i != rear ; i= (i+1)%data.length)
			count++;
		return count;
	}
	
	public boolean isFull() {
		return rear == front - 1 || (rear == data.length - 1 && front == 0);
	}
	
	public boolean isEmpty() {
		return front == -1;
	}
}
