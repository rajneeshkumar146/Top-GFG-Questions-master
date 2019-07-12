package Arrays;

public class No2_Find_Sum_subarray {

	public static void main(String[] args) {

		int[] arr = { 1, 4, 20, 3, 10, 5 };

		int sum = 24;

		Subarray_sum(arr, sum);

	}

	public static void Subarray_sum(int[] arr, int sum) {
		int n = arr.length;
		int curr_sum = arr[0], start = 0, i;

		for (i = 1; i <= n; i++) {

			while (curr_sum > sum && start < i - 1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			if (curr_sum == sum) {
				for (int p = start; p < i; p++) {
					System.out.print(arr[p] + " ");
				}
				return;
			}

			if (i < n)
				curr_sum = curr_sum + arr[i];

		}

		System.out.println("No subarray found");
		return;
	}

}
