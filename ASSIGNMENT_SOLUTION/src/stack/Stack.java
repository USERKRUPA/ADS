package stack;

public class Stack {
	private int[] data;
	private int top;

	public Stack(int size) {
		top = -1;
		data = new int[size];
	}

	public void push(int element) {
		if (isFull()) {
			System.out.println("Overflow...");
			return;
		}
		data[++top] = element;
		System.out.println("Element inserted...");
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Underflow....");
			return -1;
		}
		return data[top--];
	}

	public int countElements() {
		return top + 1;
	}

	public boolean isFull() {
		return (top == data.length -1);			
	}

	public boolean isEmpty() {
		return top == -1;
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Underflow");
			return;
		}
		System.out.println("Stack contents: ");
		for(int i = 0; i <= top; i++)
			System.out.print(data[i] + ", ");
		System.out.println("");
	}
}
