package InterviewPrep;

public class optimalbst {

	public static void optimalbst(int fre[], int arr[], int n) {
		int strg[][] = new int[n + 1][n + 1];
		int freqSumArray[] = { 0, 34, 42, 92 };
		for (int g = 0; g < n; g++) {
			for (int i = 0, j = g + i; j < n; i++, j++) {
				if (g == 0) {
					strg[i][j] = fre[j];
				}
			}
		}
		for (int x = 1; x < n; x++) {
			for (int i = 0, j = x; j < n; i++, j++) {
				int mymin = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					mymin = Math.min(mymin, strg[i][k] + strg[k + 1][j] + freqSumArray[j] - freqSumArray[i]);
				}
				strg[i][j] = mymin;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(strg[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 12, 20 };
		int freq[] = { 34, 8, 50 };
		optimalbst(freq, arr, arr.length);
	}

}
