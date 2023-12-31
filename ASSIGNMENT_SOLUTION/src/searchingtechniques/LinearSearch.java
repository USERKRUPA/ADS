package searchingtechniques;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		
		try(Scanner scan = new Scanner(System.in)){
			ListArray<Integer> list = new ListArray<Integer>();
			Integer[] arr = new Integer[5];
			for(int i = 0; i < arr.length; i++) {
				System.out.println("arr[" + (i+1) +"]: ");
				arr[i] = scan.nextInt();
			}
			list.add(arr);
			System.out.println(list);
			System.out.println("Enter element to search: ");
			int key = scan.nextInt();
			int pos = list.search(key);
			if(pos != -1) {
				System.out.println("Element found at position " + pos);
			}
			else
				System.out.println("Element not found ");	
		}
		
	}

}
