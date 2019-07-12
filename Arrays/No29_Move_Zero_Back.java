package Arrays;

//https://www.geeksforgeeks.org/move-zeroes-end-array/

public class No29_Move_Zero_Back {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 2, 0, 4, 3, 0, 5, 0 };

		func(arr);

		for (int x : arr) {
			System.out.print(x + " ");
		}
	}

	public static void func(int[] arr) {

		int start = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != 0) {

				int temp = arr[i];

				arr[i] = arr[start];

				arr[start] = temp;

				start++;

			}

		}

	}
}
