package InterviewPrep;

public class minscoretriangulation {

	public static void minscore(int arr[], int n) {
		int dp[][] = new int[n][n];

		for (int g = 0; g < n; g++) {
			for (int i = 0, j = i + g; j < n; i++, j++) {
				if (g == 2) {
					dp[i][j] = arr[i] * arr[i + 1] * arr[j];
				} else {
					for (int k = i + 1; k < j - 1; k++) {
						dp[i][j] = Math.min(dp[i][j] + arr[i] * arr[k] * arr[j], dp[k][j] + dp[i][k]);
					}
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
		int arr[] = { 1, 3, 2, 5, 4, 6 };
		int n = arr.length;

		minscore(arr, n);

	}

}
