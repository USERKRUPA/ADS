package sortingtechniques;

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

	public void quickSort() {
		quickSort(data, 0, length - 1);
	}

	private void quickSort(Object[] array, int low, int high) {
		if (low < high) {
			int pivot_index = partition(array, low, high);
			quickSort(array, low, pivot_index - 1);
			quickSort(array, pivot_index + 1, high);
		}
	}

	@SuppressWarnings("unchecked")
	private int partition(Object[] array, int left, int right) {
		Object pivot = array[right];
		int i = left; // index i points to lower bound
		int j = right - 1; // index j points to second last element of current array as last element is
							// pivot
		while (i <= j) {
			// if element at ith index is smaller than pivot then increment i
			while (((T) array[i]).compareTo((T) pivot) <= 0) {
				i++;
			}

			// if element at jth index is greater than pivot then decrement j
			while (j >= 0 && ((T) array[j]).compareTo((T) pivot) > 0) {
				j--;
			}

			// if i and j do not cross each other it means some elements are remaining for
			// comparison with pivot element
			if (i < j) {
				// swap elements at indices i and j and continue comparison
				Object tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
			}
		}
		// all elements are compared with pivot element
		// place pivot element at its place that is at i

		array[right] = array[i];
		array[i] = pivot;

		return i;
	}

	public void mergeSort() {
		mergeSort(data, 0, length - 1);
	}

	private void mergeSort(Object[] array, int low, int high) {
		int mid;
		if (low < high) {
			mid = (low + high) / 2;
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}

	@SuppressWarnings("unchecked")   // 0  2  4
	private void merge(Object[] array, int low, int mid, int high) {
		Object[] tmp = new Object[array.length];
		//System.out.println(tmp.length);
		int i = low; // for tmp array  //0
		int j = mid + 1; // for first half subarray  //3
		int k = low; // for second half subarray //0
		while (i <= mid && j <= high) { // 0 <= 2,  4 <= 4
			System.out.println();
			if (((Comparable<T>)array[i]).compareTo((T) array[j]) < 0) {
				tmp[k] = array[i];
				i++;
			} else {
				tmp[k] = array[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			tmp[k] = array[i];
			k++;
			i++;
		}

		while (j <= high) {
			// System.out.println("Inside j");
			tmp[k] = array[j];
			j++;
			k++;
		}

		for (i = 0; i < k; i++)
			array[i] = tmp[i];
	}
}
