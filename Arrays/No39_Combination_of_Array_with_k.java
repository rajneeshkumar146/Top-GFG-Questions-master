package Arrays;

public class No39_Combination_of_Array_with_k {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int r = 3;
		int n = arr.length;

		print_combi(arr, n, r);

	}

	public static void print_combi(int[] arr, int n, int r) {

		int[] data = new int[r];

		helper(arr, n, r, 0, data, 0);

	}

	public static void helper(int[] arr, int n, int r, int idx, int[] data, int i) {

		if (idx == r) {
			for (int j = 0; j < r; j++) {
				System.out.print(data[j] + " ");
			}
			System.out.println();
			return;
		}

		if (i >= n) {
			return;
		}

		data[idx] = arr[i];
		helper(arr, n, r, idx + 1, data, i + 1);

		helper(arr, n, r, idx, data, i + 1);
	}

}
