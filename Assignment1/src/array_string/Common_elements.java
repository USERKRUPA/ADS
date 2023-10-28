package array_string;

public class Common_elements {

	public static void main(String[] args) {
		int arr1[] = { 10, 21, 30, 40, 52, 78 }, arr2[] = { 10, 15, 30, 40, 61, 70, 78, 90 };
		int arr[] = findCommonElements(arr1, arr2);
		for (int val : arr) {
			if (val != 0)
				System.out.print(val + ", ");
		}
	}

	static int[] findCommonElements(int[] arr1, int[] arr2) {
		int[] arr = new int[10];
		int k = 0, j = 0;
		for (int i = 0; i < arr1.length; i++) {
			// j is not initialized as arrays are sorted...
			// search next element of arr1 from index where last element found in arr2
			for (; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					arr[k] = arr1[i];
					k++;
					break; // if element found then search next value of arr1 in arr2.
				}
				if(arr2[j] > arr1[i])
					break;
			}
		}
		/*
		 * for(int val : arr) { System.out.println(val + ", "); }
		 */
		return arr;
	}

}
