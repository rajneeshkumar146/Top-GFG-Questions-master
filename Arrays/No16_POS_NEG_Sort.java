package Arrays;

//https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/

public class No16_POS_NEG_Sort {

	public static void main(String[] args) {

		int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };

		func(arr);

	}

	public static void func(int[] arr) {

		int n = arr.length;

		int x = -1;
		int temp = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] < 0) {
				x++;
				temp = arr[x];
				arr[x] = arr[i];
				arr[i] = temp;
			}
		}

		int pos = x + 1;

		int neg = 0;

		while (pos < n && neg < pos && arr[neg] < 0) {
			temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg += 2;
		}

		for (int val : arr) {
			System.out.print(val + "  ");
		}

	}

}
