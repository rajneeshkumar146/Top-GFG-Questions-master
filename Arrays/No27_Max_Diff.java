package Arrays;

//https://www.geeksforgeeks.org/maximum-difference-between-two-elements/

public class No27_Max_Diff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 3, 3, 5, 6, 4, 8, 1 };

		basic(arr);

		better(arr);

		best(arr);
	}

	public static void basic(int[] arr) {

		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			int diff = -1;
			for (int j = i + 1; j < arr.length; j++) {

				diff = arr[j] - arr[i];

				result = Math.max(result, diff);
			}

		}

		System.out.println(result);
	}

	public static void better(int arr[]) {

		int n = arr.length - 1;

		int diff = arr[1] - arr[0];
		int curr_sum = diff;
		int max_sum = curr_sum;

		for (int i = 1; i < n - 1; i++) {

			diff = arr[i + 1] - arr[i];

			if (curr_sum > 0)
				curr_sum += diff;
			else
				curr_sum = diff;

			if (curr_sum > max_sum)
				max_sum = curr_sum;
		}

		System.out.println(max_sum);
	}

	public static void best(int[] arr) {

		int[] profit = new int[arr.length];

		int max_price = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {

			if (arr[i] > max_price)
				max_price = arr[i];

			profit[i] = Math.max(profit[i + 1], max_price - arr[i]);
		}

		System.out.println(profit[0]);

	}

	public static void func(int[] arr, int size) {

		int[] dp = new int[size];

		dp[0] = 0;

		int small = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (small > arr[i]) {
				small = arr[i];
			}

			dp[i] = Math.max(dp[i - 1], arr[i] - small);
		}

		System.out.println(dp[size - 1]);

	}

}
