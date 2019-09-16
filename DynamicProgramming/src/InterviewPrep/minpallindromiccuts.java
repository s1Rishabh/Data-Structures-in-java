package InterviewPrep;

public class minpallindromiccuts {

	public static void mincuts(String s) {
		int dp[][] = new int[s.length()][s.length()];

		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = i + g; j < s.length(); i++, j++) {
				if (s.charAt(i) == s.charAt(j) && dp[i][j] == 0) {
					dp[i][j] = 0;
				} else {
					int min = s.length();
//					for (int c = 0; c < i; c++) {
//						int lhs = dp[i][j - g + c];
//						int rhs = dp[i + 1 + c][j];
//						min = Math.min(lhs + rhs, min);
//					} 
					for (int k = i; k <= j - 1; k++) {
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j + 1]);
					}
//					min = min + 1;
					dp[i][j] += 1;
				}
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String s = "abccbc";
		mincuts(s);
	}

}
