import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("\nTail recursion for finding the factorial of the number");
			
			System.out.println("Enter a number: ");
			int no = scan.nextInt();
			System.out.println(no + "! = " + factorial(no, 1));
			}
		} // scan.close()

	

	private static int factorial(int no, int ans) {
		if (no == 1)
			return ans;
		else
			return factorial(no - 1, ans * no);
	}
}