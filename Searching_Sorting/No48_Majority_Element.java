package Searching_Sorting;

import java.util.HashMap;

//https://www.geeksforgeeks.org/majority-element/

public class No48_Majority_Element {
	public static void main(String[] args) {

		int a[] = new int[] { 2, 2, 2, 2, 5, 5, 2, 3, 3 };

		findMajority(a);

	}

	public static void findMajority(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {

				int count = map.get(arr[i]) + 1;

				if (count >= arr.length / 2) {
					System.out.println(arr[i]);
					return;
				}

				map.put(arr[i], count);

			} else {
				map.put(arr[i], 1);
			}

		}

		System.out.println("N/A");

	}
}
