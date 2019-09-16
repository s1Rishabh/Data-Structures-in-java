package L001;

import java.util.Scanner;

public class Strings {
	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String s1;
		s1 = scn.next();
		substring(s1);
	}

	public static void substring(String s1) {
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = i + 1; j <= s1.length(); j++) {
				System.out.println(s1.substring(i, j));
			}
		}
	}
    
}
