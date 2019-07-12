package Arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/

public class No6_Find_Pair_with_given_Diff {

	public static void main(String[] args) {

		int[] arr = { 5, 20, 3, 2, 50, 80 };

		int sum = 78;

		pair(arr, sum);

	}

	public static void pair(int[] arr, int sum) {
		int i = 0;
		int j = 0;

		Arrays.sort(arr);

		while (i < arr.length && j < arr.length) {

			if (arr[j] - arr[i] == sum) {
				System.out.println(arr[j] + "," + arr[i]);
				return;
			}

			if (arr[j] - arr[i] < sum) {
				j++;
			} else {
				i++;
			}
		}

		System.out.println("Not Found");

	}

}
