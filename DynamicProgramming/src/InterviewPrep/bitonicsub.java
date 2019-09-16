package InterviewPrep;

import java.util.ArrayList;
import java.util.HashMap;

public class bitonicsub {

	public static void main(String[] args) {
		int arr[] = { 10, 19, 15 };
		System.out.println(longestSubsequenceLength(arr, 2, 2));
	}

	public static int longestSubsequenceLength(int arr[], int k, int l) {
		int win[] = new int[arr.length - k + 1];
		int won[] = new int[arr.length - l + 1];
		int max = 0;
		for (int i = 0; i < (arr.length) - k + 1; i++) {
			for (int j = i; j < (i + k); j++) {
				max += arr[j];
			}
			win[i] = max;
			max = 0;
		}
		max = 0;
		for (int i = 0; i < arr.length - l + 1; i++) {
			for (int j = i; j < (i + l); j++) {
				max += arr[j];
			}
			won[i] = max;
			max = 0;
		}
		int ans1 = Integer.MIN_VALUE;
		int ans2 = Integer.MIN_VALUE;
		for (int i = 0; i < win.length; i++) {
			if (ans1 < win[i])
				ans1 = win[i];
		}
		for (int i = 0; i < won.length; i++) {
			if (ans2 < won[i])
				ans2 = won[i];
		}
		if(ans1==ans2){
		    return -1;
		}
		return ans1 + ans2;
	}

	public static int longestSubsequenceLength(final ArrayList<Integer> A) {
		ArrayList<Integer> leftLIS = new ArrayList<>();
		ArrayList<Integer> rightLIS = new ArrayList<>();

		if (A.isEmpty())
			return 0;

		for (int i = 0; i < A.size(); i++) {
			leftLIS.add(i, 1);
			rightLIS.add(i, 1);
		}
		int max = 0;
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (A.get(i) > A.get(j)) {
					leftLIS.set(i, Math.max(leftLIS.get(i), leftLIS.get(j) + 1));
				}
			}
		}

		for (int i = A.size() - 2; i >= 0; i--) {
			for (int j = A.size() - 1; j > i; j--) {
				if (A.get(i) > A.get(j)) {
					rightLIS.set(i, Math.max(rightLIS.get(i), rightLIS.get(j) + 1));
				}
			}
		}

		for (int i = 0; i < A.size(); i++) {
			if (max < (leftLIS.get(i) + rightLIS.get(i)) - 1) {
				max = (leftLIS.get(i) + rightLIS.get(i)) - 1;
			}
		}

		return max;
	}
}
