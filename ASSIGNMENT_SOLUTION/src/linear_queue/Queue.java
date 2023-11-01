package linear_queue;

public class Queue {
	private int rear;
	private int front;
	private int[] data;
	 
	public Queue(int size) {
		rear = front = -1;
		data = new int[size];
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Queue is Empty...");
			return;
		}
		System.out.println("Stack contents: ");
		for(int i = front; i <= rear; i++)
			System.out.print(data[i] + ", ");
		System.out.println("");
	}
	
	public void enqueue(int element) {
		if(isFull()) {
			System.out.println("Queue is Full...");
			return;
		}
		data[++rear] = element;
		if(front == -1) 	
			front = 0;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty...");
			return -1;
		}
		return data[front++];
	}
	
	public int countElements() {
		return rear - front + 1;
	}
	
	public boolean isFull() {
		return rear == data.length -1;
	}
	
	public boolean isEmpty() {
		return front == -1 || front > rear;
	}
	
}
