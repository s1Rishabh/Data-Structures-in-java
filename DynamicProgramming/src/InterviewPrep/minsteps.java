package InterviewPrep;

import java.util.Scanner;

public class minsteps {

	public static int minjumps(int arr[], int n) {
		if (arr[0] == 0) {
			return 0;
		}
		if (arr[0] < 0) {
			return -1;
		}
		int mymax = Integer.MIN_VALUE;
		int val = arr[0];
		int s = 1;
		int c = 1;
		while (val < arr.length) {
			for (int j = s; j <= val; j++) {
				if (arr[j] > mymax) {
					mymax = arr[j];
					s = j + 1;
				}
			}
			if (mymax + s - 1 >= arr.length - 1) {
				c++;
				return c;
			} else {
				c++;
				val = mymax;
			}
		}
		return 0;
	}

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int val = minjumps(arr, n);
			System.out.println(val);
		}
	}

}
