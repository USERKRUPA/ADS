package searchingtechniques;

public class LinearSearch<T extends Comparable<T>> {
	private Object data[];
	private int capacity;
	private int length;
	
	LinearSearch(){
		capacity = 5;
		length = 0;
		data = new Object[capacity];
	}
	LinearSearch(int capacity){
		this.capacity = capacity;
		this.length = 0;
		data = new Object[capacity];
	}
	
	void add(T ... values) {
		for(T t : values) {
			data[length] = t;
			length++;
		}
	}
	public String toString() {
		String res = "";
		for(int i = 0; i < length; i++)
			res = res + data[i] + ", ";
		return res;
	}
}
