package Arrays;

public class No25_Stock_Buy_Sell_2_Times {

	public static void main(String[] args) {

		int arr[] = { 2, 30, 15, 10, 8, 25, 80 };

		func(arr);
	}

	public static void func(int[] arr) {

		int[] profit = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			profit[i] = 0;
		}

		// max profit one transaction
		int max_price = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {

			if (arr[i] > max_price)
				max_price = arr[i];

			profit[i] = Math.max(profit[i + 1], max_price - arr[i]);
		}
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
		for (int y : profit) {
			System.out.print(y + " ");
		}

		// max profit nd transaction
		int min_price = arr[0];
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < min_price)
				min_price = arr[i];

			profit[i] = Math.max(profit[i - 1], profit[i] + (arr[i] - min_price));
		}

		System.out.println();
		for (int y : profit) {
			System.out.print(y + " ");
		}
		int result = profit[arr.length - 1];

		System.out.println(result);
	}
}
