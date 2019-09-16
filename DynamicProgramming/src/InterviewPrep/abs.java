package InterviewPrep;

import java.util.LinkedList;
import java.util.Scanner;

public class abs {

	static LinkedList<Integer> list = new LinkedList<>();

	private static void increment(int x, int y) {
	}

	private static void pop() {
		if (list.size() == 0) {
			System.out.println("EMPTY");
		} else {
			list.removeLast();
			int val = list.peek();
			System.out.println(val);
		}
	}

	private static void push(int x) {
		list.addLast(x);
		System.out.println(x);
	}

	public static void fun(String[] op) {
		String p = "push";
		String pop = "pop";
		String inc = "inc";
		for (int i = 0; i < op.length; i++) {
			String ans = new String();
			String val = op[i];
			for (int j = 0; j < val.length(); j++) {

				while (j < val.length() - 1) {
					ans += val.charAt(j);
					j++;
				}
				if (ans.contains(p)) {
					j++;
					int x = Character.getNumericValue(ans.charAt(j));
					push(x);
				} else if (ans.contains(pop)) {
					pop();
				} else if (ans.contains(inc)) {
					j++;
					int x = Character.getNumericValue(ans.charAt(j));
					j++;
					int y = Character.getNumericValue(ans.charAt(j));
					increment(x, y);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String op[] = new String[n];
		for (int i = 0; i < n; i++) {
			op[i] = scn.next();
		}
		fun(op);
	}

}
