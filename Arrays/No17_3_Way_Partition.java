package Arrays;

//https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/

public class No17_3_Way_Partition {

	public static void main(String[] args) {

		int arr[] = { 1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32 };
		int low = 14;
		int high = 20;

		func(arr, 14, 20);

		for (int x : arr) {

			System.out.print(x + " ");

		}

	}

	public static void func(int[] arr, int low, int high) {

		int n = arr.length;

		int start = 0;
		int end = arr.length - 1;

		for (int i = 0; i < end;) {

			if (arr[i] < low) {

				int temp = arr[start];

				arr[start] = arr[i];

				arr[i] = temp;

				start++;

				i++;

			}

			else if (arr[i] > high) {
				int temp = arr[end];

				arr[end] = arr[i];

				arr[i] = temp;

				end--;

			} else {
				i++;
			}

		}
	}

}
