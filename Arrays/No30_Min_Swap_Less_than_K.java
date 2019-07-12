package Arrays;

//https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/

public class No30_Min_Swap_Less_than_K {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 2, 7, 9, 5, 8, 7, 4 };
		int k = 3;

		func(arr, k);
	}

	public static void func(int[] arr, int k) {

		int small = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= k) {
				++small;
			}

		}

		int big = 0;

		for (int i = 0; i < small; i++) {
			if (arr[i] > k) {
				++big;
			}
		}

		int ans = big;

		for (int i = 0, j = small; j < arr.length; i++, j++) {

			if (arr[i] > k) {
				--big;
			}

			if (arr[j] > k) {
				++big;
			}

			ans = Math.max(ans, big);

		}

		System.out.println(big);

	}

}
