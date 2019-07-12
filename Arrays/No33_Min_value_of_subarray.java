package Arrays;

//https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/

public class No33_Min_value_of_subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 3, 6, 10, 11, 15 };

		func(arr);

	}

	public static void func(int[] arr) {

		int res = 1;
		int n = arr.length;

		for (int i = 0; i < n && arr[i] <= res; i++) {
			res = res + arr[i];
		}
		System.out.println(res);

	}

}
