package Arrays;

import java.util.HashMap;

public class No40_SubArray_Sum_Div_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { -2, 2, -5, 12, -11, -1, 7 };
		int k = 3;

		func(arr, arr.length, 3);
	}

	public static void func(int[] arr, int n, int k) {

		int[] mod = new int[n];

		int sum = 0;

		int max = 0;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {

			sum += arr[i];

			mod[i] = sum % k;
		}

		for (int i = 0; i < n; i++) {

			if (mod[i] == 0) {
				max = i + 1;
			} else if (map.containsKey(mod[i]) == false) {
				map.put(mod[i], i);
			} else if (max < i - map.get(mod[i])) {

				max = i - map.get(mod[i]);
			}

		}

		System.out.println(max);

	}

}
