package Arrays;

public class No14_Sorted_Roatated_Pair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 11, 15, 6, 8, 9, 10 };
		int find = 16;

		func(arr, find);

	}

	public static void func(int[] arr, int find) {

		int n = arr.length;

		int l = 0;

		int r = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] > arr[i + 1]) {

				l = i;
				r = i + 1;
				break;

			}

		}

		int x = l;

		while (true) {

			int mysum = arr[l] + arr[r];

			if (mysum == find) {

				System.out.println(arr[l] + " " + arr[r]);
				return;

			}

			if (mysum < find) {
				r = (r + n - 1) % n;
			} else if (mysum > find) {

				l = (l - 1) % n;
			}

		}

		// System.out.println("Not Found");

	}

}
