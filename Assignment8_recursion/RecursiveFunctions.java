//package recursion;

import java.util.Scanner;

public class RecursiveFunctions {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("\n1. Find the sum of digits of the number" + "\n2. Find the square of the number"
					+ "\n3. Tail recursion for finding the factorial of the number"
					+ "\n4. Check whether the number is palindrome or not? ");
			System.out.println("Enter your choice: ");
			int choice = scan.nextInt();
			System.out.println("Enter a number: ");
			int no = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Sum of Digits: " + sumOfDigits(no));
				break;
			case 2:
				System.out.println("Square of number: " + square(no));
				break;
			case 3:
				System.out.println(no + "! = " + factorial(no, 1));
				break;
			case 4:
				System.out.println(isPalindrome(no) ? "Palindrome" : "Not Palindrome");
				break;
			default:
				System.out.println("Enter valid choice...");
			}
		} // scan.close()

	}

	private static int sumOfDigits(int no) {
		if (no == 0)
			return 0;
		else
			return sumOfDigits(no / 10) + no % 10;
	}

	private static int square(int no) {
		if (no == 1)
			return 1;
		else
			return (2 * no - 1) + square(no - 1);
	}

	private static int factorial(int no, int ans) {
		if (no == 1)
			return ans;
		else
			return factorial(no - 1, ans * no);
	}

	private static boolean isPalindrome(int no) {
		if (reverse(no, 0) == no)
			return true;
		else
			return false;
	}

	private static int reverse(int no, int rev) {
		if (no == 0)
			return rev;
		else {
			rev = (rev * 10) + (no % 10);
			return reverse(no / 10, rev);
		}
	}

}
