package searchingtechniques;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			ListArray<Integer> list = new ListArray<Integer>();
			Integer[] arr = new Integer[5];
			for(int i = 0; i < arr.length; i++) {
				System.out.println("arr[" + (i+1) +"]: ");
				arr[i] = scan.nextInt();
			}
			list.add(arr);
			//Arrays.sort(arr);
			list.bubbleSort();
			System.out.println(list);
			System.out.println("Enter element to search: ");
			int key = scan.nextInt();
			int pos = list.binarySearch(key, 0, arr.length-1);
			if(pos != -1) {
				System.out.println("Element found at position " + pos);
			}
			else
				System.out.println("Element not found ");	
		}
	}

}
