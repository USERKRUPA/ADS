package array_string;

import java.util.HashMap;
import java.util.Map;

public class ArrayElementCount {

	public static void main(String[] args) {
		int arr[] = { -20, 13, -10, 21, 30, -10, 21, -10, 23 };
		int max = 0;
		int ele = 0;
		Map<Integer, Integer> hmap = new HashMap<>();
		// int counter = 0;

		for (int i = 0; i < arr.length; i++) {
			if (hmap.containsKey(arr[i])) {
				int value = hmap.get(arr[i]);
				hmap.put(arr[i], ++value); //replace
			} else
				hmap.put(arr[i], 1);
			if(hmap.get(arr[i]) > max) { // 1> 0
				max = hmap.get(arr[i]);
				ele = arr[i];
			}
		}

		/*
		 * hmap.forEach((k, v) -> { int max = 0;if(v > max) max = v; });
		 */
		/*
		 * int max = 0; int ele = 0;
		 * 
		 * for(int i = 0; i < arr.length; i++) { if(hmap.get(arr[i]) > max) { // 1> 0
		 * max = hmap.get(arr[i]); ele = arr[i]; } }
		 */
			
		System.out.println("value " + ele + " is repeated " + max + " times");

	}

}
