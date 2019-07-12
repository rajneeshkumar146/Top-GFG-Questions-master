package Arrays;

//https://www.geeksforgeeks.org/maximum-product-subarray/

public class No20_Max_Product_subarray {

	public static void main(String[] args) {

		int arr[] = { -2, -3, 0, -2, -40 };

		func(arr);

	}

	public static void func(int[] arr) {
		int min = arr[0];
		int max = arr[0];
		int ans = 0;

		for (int i = 0; i < arr.length; i++) {

			int tempmax = max;

			max = Math.max(Math.max(min * arr[i], max * arr[i]), arr[i]);
			min = Math.min(Math.min(tempmax * arr[i], min * arr[i]), arr[i]);

			ans = Math.max(max, ans);

		}

		System.out.println(ans);
	}

}
