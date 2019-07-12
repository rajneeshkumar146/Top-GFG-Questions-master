package Arrays;

import java.util.HashMap;

//https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/

public class No19_Largest_SubArray_0_1 {

	public static void main(String[] args) {

		int arr[] = { 1, 0, 1, 1, 1, 0, 0 };

		func(arr);
		// TODO Auto-generated method stub

	}

	public static void func(int[] arr) {

		int sum = 0;
		int maxsize = -1;
		int start = 0;
		int startresult = 0;
		int end = 0;
		int endresult = 0;
		int maxresult = 0;

		for (int i = 0; i < arr.length; i++) {

			sum = (arr[i] == 0) ? -1 : 1;

			for (int j = i + 1; j < arr.length; j++) {

				sum += (arr[j] == 0) ? -1 : 1;

				if (sum == 0 && maxsize < j - i + 1) {

					maxsize = j - i + 1;

					start = i;

					end = j;

				}

			}

			if (maxsize == -1) {
				System.out.println("NULL");

			} else if (maxsize > maxresult) {

				maxresult = maxsize;
				startresult = start;
				endresult = end;

			}

		}

		System.out.println(startresult + " " + endresult + " " + maxresult);
	}

	public static void zerosumarr(int[] arr) {
		// Write your code here

		HashMap<Integer, Integer> map = new HashMap<>();

		int MasterSum = 0;
		int ctr = 0;

		map.put(0, 1);

		for (int i = 0; i < arr.length; i++) {

			MasterSum += arr[i];

			if (map.containsKey(MasterSum)) {
				if (map.get(MasterSum) >= 1) {
					ctr += map.get(MasterSum);
				}
				map.put(MasterSum, map.get(MasterSum) + 1);
			} else {
				map.put(MasterSum, 1);
			}

		}

		System.out.println(ctr);

	}
}
