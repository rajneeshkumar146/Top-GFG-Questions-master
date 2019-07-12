package Arrays;

public class No41_Merge_To_Palindrome {

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 3, 1, 5 };

		func(arr, arr.length);

	}

	public static void func(int[] arr, int n) {

		if (n == 0) {
			return;
		}

		int i = 0;
		int j = n - 1;
		int ans = 0;

		for (; i <= j;) {

			if (arr[i] == arr[j]) {

				i++;
				j--;
			} else if (arr[i] > arr[j]) {
				j--;
				arr[j] += arr[j + 1];
				ans++;

			} else {

				i++;
				arr[i] += arr[i - 1];
				ans++;
			}

		}

		System.out.println(ans);

	}

}
