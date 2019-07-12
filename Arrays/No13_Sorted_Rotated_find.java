package Arrays;

//https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/

public class No13_Sorted_Rotated_find {

	public static void main(String[] args) {

		int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };

		int find = 3;

		func(arr, find);

	}

	public static void func(int[] arr, int find) {
		int max = 0;
		int m = 0;
		int min = 0;
		int n = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] > arr[i + 1]) {

				max = arr[i];
				m = i;
				min = arr[i + 1];
				n = i + 1;

			}

		}

		if (arr[0] <= find && max >= find) {

			if (max == find) {

				System.out.println(m);
				return;

			}

			if (arr[0] == find) {
				System.out.println("0");
				return;
			}

			for (int i = 0; i < m; i++) {

				if (find == arr[i]) {
					System.out.println(i);
					return;
				}

			}

		}

		if (min <= find && arr[arr.length - 1] >= find) {

			if (min == find) {
				System.out.println(n);
				return;

			}

			if (arr[arr.length - 1] == find) {
				System.out.println(arr.length - 1);
				return;
			}

			for (int i = n; i < arr.length - 1; i++) {

				if (find == arr[i]) {
					System.out.println(i);
					return;
				}

			}

		}

		System.out.println("Not Found");

	}
}
