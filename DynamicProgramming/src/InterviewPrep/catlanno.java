package InterviewPrep;

public class catlanno {

	public static void catlan(int n) {

		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = 0;
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(dp[i] + " ");
		}
	}

	public static void main(String args[]) {
		int n = 5;
		catlan(n);
	}

}
