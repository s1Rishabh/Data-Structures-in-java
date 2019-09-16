package InterviewPrep;

public class stack {

	static stack<Integer> st = new stack();

	private static void increment(int x, int y) {
	}

	private static void pop() {

	}

	private static void push(int x) {

	}

	public static void fun(String[] op) {

		String p = "push";
		String pop = "pop";
		String inc = "inc";
		for (int i = 0; i < op.length; i++) {
			String ans = new String();
			String val = op[i];

			for (int j = 0; j < val.length(); j++) {
				while (val.charAt(j) != ' ') {
					ans += val.charAt(i);
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
		// TODO Auto-generated method stub

	}

}
