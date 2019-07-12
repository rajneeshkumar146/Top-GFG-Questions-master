package Arrays;

public class No26_Stock_Buy_Sell_K_Times {

	public static void main(String[] args) {

		int[] arr = { 12, 14, 17, 10, 14, 13, 12, 15 };

		System.out.println(maxProfit(arr, arr.length, 3));
	}

	static int maxProfit(int price[], int n, int k) {

		int profit[][] = new int[k + 1][n + 1];

		for (int i = 0; i <= k; i++)
			profit[i][0] = 0;

		for (int j = 0; j <= n; j++)
			profit[0][j] = 0;

		for (int i = 1; i <= k; i++) {

			int prevDiff = Integer.MIN_VALUE;

			for (int j = 1; j < n; j++) {
				prevDiff = Math.max(prevDiff, profit[i - 1][j - 1] - price[j - 1]);
				profit[i][j] = Math.max(profit[i][j - 1], price[j] + prevDiff);
			}
		}

		return profit[k][n - 1];
	}

	public static void print(int[][] mat, int n, int k) {
		for (int i = 1; i <= k; i++) {

			for (int j = 1; j < n; j++) {

				System.out.print(+mat[i][j] + " ");
			}

			System.out.println();
		}

	}

}
