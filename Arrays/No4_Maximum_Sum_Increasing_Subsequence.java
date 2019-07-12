package Arrays;

public class No4_Maximum_Sum_Increasing_Subsequence {

	public static void main(String[] args) {

		int[] arr = { -7, 1, 5, 2, -4, 3, 0 };

		increasing_sub(arr);

	}

	public static void increasing_sub(int[] arr) {
		int[] dp = new int[arr.length];

		dp[0] = 1;

		int omax = 0;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= i - 1; j++) {

				if (arr[i] > arr[j]) {
					if (dp[j] > dp[i]) {
						dp[i] = dp[j];
					}
				}
			}

			dp[i] += 1;

			if (omax < dp[i]) {
				omax = dp[i];
			}
		}

		System.out.println(omax);

	}
}
