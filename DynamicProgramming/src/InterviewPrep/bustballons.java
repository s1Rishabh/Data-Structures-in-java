package InterviewPrep;

public class bustballons {

	static Integer[][] dp = null;

	public static int maxCoins(int[] nums) {
		int n = nums.length;
		dp = new Integer[n][n];
		return maxCoins(nums, 0, n - 1);
	}

	private static int maxCoins(int[] n, int i, int j) {
		if (i > j)
			return 0;
		if (dp[i][j] != null)
			return dp[i][j];
		dp[i][j] = 0;
		for (int k = i; k <= j; k++) {
			int prod = n[k];
			if (i - 1 >= 0)
				prod *= n[i - 1];
			if (j + 1 < n.length)
				prod *= n[j + 1];
			dp[i][j] = Math.max(dp[i][j], maxCoins(n, i, k - 1) + prod + maxCoins(n, k + 1, j));
		}

		for (i = 0; i < dp.length; i++) {
			for (j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[i][j];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;

		maxCoins(arr);

	}

}
