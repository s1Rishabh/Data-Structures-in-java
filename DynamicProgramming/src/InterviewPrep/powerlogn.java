package InterviewPrep;

import java.util.Scanner;

public class powerlogn {

	public static int power(int x, int y) {
		if (y == 0) {
			return 1;
		}
		int temp = power(x, y / 2);
		if (y % 2 == 0) 
		{
			return temp * temp;
		} else 
		{
			if (y > 0) {
				return temp * temp * x;
			} else {
				return (temp * temp) / x;
			}
		}
	}

	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			int vsl = power(x, y);
			System.out.println(vsl);
		}
	}

}
