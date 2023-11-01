package array;

import java.util.Scanner;

public class ArrayOperations {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Read the count of elements from user to create the array.
		int n;
		System.out.println("Enter no of elements to create an array: ");
		n = sc.nextInt();
		int[] arr = new int[n];

		// Initialize the array using user input.
		System.out.println("Enter " + n + " numbers: ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		boolean exit = false;
		while (!exit) {
			System.out.println("\n0. Exit\n1. Display the array\n2. Reverse the array"
					+ "\n3. Replace the nth element from the array and print"
					+ "\n4. Find the addition of all elements of the array"
					+ "\n5. Find the maximum number from the array"
					+ "\n6. Print the average of all the elements from the array."
					+ "\n7. Display the even and odd number from the array separately.");
			System.out.println("Enter your choice: ");
			switch (sc.nextInt()) {
			case 1:
				printArray(arr);
				break;
			case 2:
				reverseArray(arr);
				break;
			case 3:
				System.out.println("Enter index and new element: ");
				replaceElement(sc.nextInt(), sc.nextInt(), arr);
				break;
			case 4:
				System.out.println("Sum of elements: " + addElements(arr));
				break;
			case 5:
				System.out.println("Maximum no: " + maxElement(arr));
				break;
			case 6:
				System.out.println("Average of all elements of an array: " + avgElements(arr));
				break;
			case 7:
				printOddEvenElements(arr);
				break;
			case 0:
				exit = true;
				break;
			default:
				System.out.println("Enter valid choice: ");
			}
		}
		sc.close();
	}

	private static void printOddEvenElements(int[] arr) {
		int even[] = new int[arr.length];
		int odd[] = new int[arr.length];
		int i, j, k;
		for (i = 0, j = 0, k = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				even[j] = arr[i];
				j++;
			}
			else {
				odd[k] = arr[i];
				k++;
			}
		}
		System.out.println("Odd Elements: ");
		for(i = 0; i < k; i++)
			System.out.println(odd[i]);
		System.out.println("Even Elements: ");
		for(i = 0; i < j; i++)
			System.out.println(even[i]);
	}
	

	private static float avgElements(int[] arr) {
		return (float) addElements(arr) / arr.length;
	}

	private static int maxElement(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}

	private static int addElements(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	private static void replaceElement(int index, int value, int[] arr) {
		if(index > arr.length - 1)
			System.out.println("Index is out of range");
		else
			arr[index] = value;
	}

	private static void reverseArray(int[] arr) {
		System.out.println("Reverse array is: ");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}

	private static void printArray(int[] arr) {
		System.out.println("Elements of an array: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
	}

}
