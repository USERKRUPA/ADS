import java.util.Scanner;

public class PalindromeNo {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("\nCheck whether the number is palindrome or not?");
			
			System.out.println("Enter a number: ");
			int no = scan.nextInt();
			System.out.println(isPalindrome(no) ? "Palindrome" : "Not Palindrome");
			}
		} // scan.close()

	

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