package searchingtechniques;

import java.util.List;

public class ListArray<T extends Comparable<T>> {
	private Object data[];
	private int capacity;
	private int length;

	ListArray() {
		capacity = 5;
		length = 0;
		data = new Object[capacity];
	}

	ListArray(int capacity) {
		this.capacity = capacity;
		this.length = 0;
		data = new Object[capacity];
	}

	public ListArray(List<T> asList) {
		capacity = asList.size();
		data = new Object[capacity];
		for (T i : asList) {
			data[length] = i;
			length++;
		}
	}

	@SuppressWarnings("unchecked")
	void add(T... values) {
		for (T t : values) {
			if (length >= capacity) {
				Object[] tmp = new Object[capacity * 2];
				System.arraycopy(data, 0, tmp, 0, data.length);
				data = tmp;
			}
			data[length] = t;
			length++;
		}
	}

	public String toString() {
		String res = "";
		for (int i = 0; i < length; i++)
			res = res + data[i] + ", ";
		return res;
	}

	@SuppressWarnings("unchecked")
	public void bubbleSort() {
		for (int pass = 0; pass < length; pass++) {
			boolean exchg = false;
			for (int i = 0; i < length - 1; i++) {
				// inside for loop
				// System.out.println("Inside for" +((T) data[i]).compareTo((T) data[i+1]));
				if (((T) data[i]).compareTo((T) data[i + 1]) == 1) {
					// swap(data[i], data[i+1]);
					Object tmp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = tmp;
					exchg = true;
				}
			}
			// check whether swapping occurs or not
			if (!exchg)
				break;
		}
	}

	/*
	 * private void swap(Object object1, Object object2) { Object tmp = object1;
	 * object1 = object2; object2 = tmp; }
	 */

	public int search(T key) {
		for (int i = 0; i < length; i++) {
			if (data[i] == key)
				return i;
		}
		return -1;
	}
	

	@SuppressWarnings("unchecked")
	public int binarySearch(T key, int low, int high) {
		int mid = -1;
		if (low <= high) {
			mid = (high + low) / 2;
			if ((key.compareTo((T) data[mid])) == 0)
				return mid;
			if (key.compareTo((T) data[mid]) == 1) 
				return binarySearch(key, mid + 1, high);
			return binarySearch(key, low, mid - 1);
		}
		return mid;
	}

}
