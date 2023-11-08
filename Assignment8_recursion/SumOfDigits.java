import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("\nFind the sum of digits of the number");
			
			System.out.println("Enter a number: ");
			int no = scan.nextInt();
			System.out.println("Sum of Digits: " + sumOfDigits(no));
			}
		} // scan.close()

	

	private static int sumOfDigits(int no) {
		if (no == 0)
			return 0;
		else
			return sumOfDigits(no / 10) + no % 10;
	}
}