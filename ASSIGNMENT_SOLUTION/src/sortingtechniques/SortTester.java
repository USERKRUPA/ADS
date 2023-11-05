package sortingtechniques;

import java.util.Scanner;

public class SortTester {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			ListArray<Integer> list = new ListArray<Integer>();
			Integer[] arr = new Integer[5];
			for (int i = 0; i < arr.length; i++) {
				System.out.println("arr[" + (i + 1) + "]: ");
				arr[i] = scan.nextInt();
			}
			list.add(arr);
			System.out.println(list);
			//list.quickSort();
			list.mergeSort();
			System.out.println(list);
		}
	}

}
