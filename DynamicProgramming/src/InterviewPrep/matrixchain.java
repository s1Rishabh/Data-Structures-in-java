package InterviewPrep;

public class matrixchain {

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

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[1][n - 1];
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50, 60 };
		int n = arr.length;

		System.out.println(MatrixChainOrder(arr, n));

	}

}
