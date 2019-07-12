package Arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/

public class No28_Min_Max_Height_Diff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 15, 10 };

		int k = 6;

		func(arr, k);
	}

	public static void func(int[] arr, int k) {

		Arrays.sort(arr);

		int n = arr.length;

		int ans = arr[n - 1] - arr[0];

		int small = arr[0];

		int big = arr[n - 1];

		int temp = 0;

		if (small > big) {
			temp = small;
			small = big;
			big = small;
		}

		for (int i = 0; i < n; i++) {

			int sub = arr[i] - k;
			int add = arr[i] + k;

			if (sub >= small || add <= big) {
				continue;
			}

			if (big - sub <= add - small) {
				small = sub;
			} else {
				big = add;
			}

		}

		System.out.println(Math.min(ans, big - small));

	}

}
