package array_string;

import java.util.Scanner;

public class oneAwayString {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1, s2;
		System.out.println("Enter string1: ");
		s1 = sc.next();
		System.out.println("Enter string2: ");
		s2 = sc.next();

		int count = 0, i;
		if (s1.equals(s2)) {
			System.out.println("One away...");
			return;
		}
		if(s1.length() == s2.length()) {
			for ( i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i) && count == 0) {
					count++;
				}
				if(count >= 1) {
					break;
				}
			}
			System.out.println("Not one away...");
			return;
		}
		if (s1.length() == s2.length() + 1) {
			for( i = 0; i < s2.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					break;
				}
		.	}
			System.out.println("Not one away...");
			return;
		}
		if (s2.length() == s1.length() + 1) {
			for( i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					break;
				}
			}
			if(i == s1.length())
				System.out.println("Not one away...");
			return;
		}
		sc.close();
	}

}
