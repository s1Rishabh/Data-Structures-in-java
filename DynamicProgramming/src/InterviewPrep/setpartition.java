package InterviewPrep;

public class setpartition {

	public static void minscore(int n, int k) {
		int dp[][] = new int[n + 1][n + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp.length; j++) {
				if (i == 1 || j == 1) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] * k + dp[i - 1][j - 1];

				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int n = 3;
		int k = 2;
		minscore(n, k);

	}

}
