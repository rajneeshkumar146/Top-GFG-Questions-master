package Arrays;

///https://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/

public class No31_Largest_K_Sub_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 2, 3, -10, -3 };
		int k = 4;

		func(arr, k);

	}

	public static void func(int[] arr, int k) {

		if (k == arr.length) {
			System.out.println(arr);
		}

		int start = 0;

		int end = k - 1;

		int max = Integer.MIN_VALUE;

		while (end < arr.length) {

			int sum = 0;

			for (int i = start; i <= end; i++) {

				sum += arr[i];

			}
			start++;
			end++;

			max = Math.max(sum, max);
		}

		System.out.println(max);

	}
}
