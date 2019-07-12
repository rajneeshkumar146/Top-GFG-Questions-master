package Arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/chocolate-distribution-problem/

public class No7_Chocolate_Dist {

	public static void main(String[] args) {

		int[] arr = { 12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50 };

		int n = 7;

		
		func(arr , n);
	}

	public static void func(int[] arr, int n) {

		Arrays.sort(arr);

		int diff = arr[arr.length - 1] - arr[0];

		int left = 0;
		int right = n - 1;

		while (right < arr.length) {
			if (diff > (arr[right] - arr[left])) {
				diff = arr[right] - arr[left];
			}

			right++;
			left++;
		}

		System.out.println(diff);

	}

}
