package L001;

import java.util.Scanner;

public class Loops {
	private static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scn.nextInt();

		// int[] arr =input(n) ;
		// int res=scn.nextInt() ;
		// System.out.println(findmax(arr, n)) ;
		// System.out.println(findmin(arr, n)) ;
		// System.out.println(element(arr,res));
		// printinc(n) ;
		// printdec(n) ;
		System.out.println(fibonacci1(n));
	}

	public static int[] input(int n) {
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}

	public static boolean element(int[] arr, int res) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == res) {
				return true;

			}
		}
		return false;
	}

	public static void printinc(int n) {
		for (int i = 0; i <= n; i++) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	public static void printdec(int n) {
		for (int i = n; i >= 0; i--) {
			System.out.print(i + ", ");
		}
	}

	public static int findmax(int[] arr, int n) {
		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}

		}
		return max;
	}

	public static int findmin(int[] arr, int n) {
		int min = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}

		}
		return min;
	}

	public static void fibonacci(int n) {

		int first = 0;
		int second = 1;

		System.out.print(first + " ");
		System.out.print(second);
		System.out.print(" ");
		for (int i = 2; i < n; i++) {
			int third = first + second;
			if (third < n) {
				System.out.print(third + " ");
				first = second;
				second = third;
			} else {
				break;
			}
		}

	}

	public static int fibonacci1(int n) {

		int first = 0;
		int second = 1;
		int third=0 ; 
		for (int i = 2; i <= n; i++) {
		   third = first + second;
			first = second;
			second =third; 
		} 
		return third; 
	}

}