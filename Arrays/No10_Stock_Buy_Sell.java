package Arrays;

//https://www.geeksforgeeks.org/stock-buy-sell/

public class No10_Stock_Buy_Sell {

	public static void main(String[] args) {

// TODO Auto-generated method stub

		int arr[] = { 100, 180, 260, 310, 40, 535, 695 };

		func(arr);

	}

	public static void func(int[] arr) {

		int[] dp = new int[arr.length];

		dp[0] = 0;
		for (int i = 0; i < arr.length; i++) {

			int max = -1;
			for (int j = 1; j < arr.length; j++) {

//				T[j] = Math.max(T[j - 1], maxDiff + prices[j]);

				dp[j] = Math.max(max, dp[j - 1]);
				max = Math.max(arr[j] - arr[j], dp[j]);

			}
		}

		System.out.println(dp[arr.length - 1]);

	}

}