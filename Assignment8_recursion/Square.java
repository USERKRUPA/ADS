import java.util.Scanner;

public class Square {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("\nFind the square of the number");
			
			System.out.println("Enter a number: ");
			int no = scan.nextInt();
			System.out.println("Square of number: " + square(no));
			}
		} // scan.close()

	

	private static int square(int no) {
		if (no == 1)
			return 1;
		else
			return (2 * no - 1) + square(no - 1);
	}
}