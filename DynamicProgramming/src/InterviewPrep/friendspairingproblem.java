package InterviewPrep;

public class friendspairingproblem {

	public static int MatrixChainOrder(int p[], int n) {

		int dp[][] = new int[n][n];
		int q = 0;
		for (int i = 1; i < n; i++)
			dp[i][i] = 0;
		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {
				int j = i + l - 1;
				if (j == n)
					continue;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++)
					q = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
				if (q < dp[i][j])
					dp[i][j] = q;
			}
		}
		return dp[1][n - 1];
	}

	public static void fun(int n) {

		int dp[] = new int[n + 2];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] * (i - 2);
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println(dp[dp.length - 1]);
	}

	public static void main(String[] args) {

		int n = 8;
		fun(n);

	}

}
