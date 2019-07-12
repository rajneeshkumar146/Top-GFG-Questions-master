package Arrays;

//https://www.geeksforgeeks.org/counting-inversions/

public class No21_Count_Inversion {

	public static void main(String[] args) {

		int arr[] = new int[] { 1, 20, 6, 4, 5 };

		System.out.println(MergeSort(arr, arr.length));

	}

	public static int MergeSort(int arr[], int array_size) {
		int temp[] = new int[array_size];
		return mergeSortHelper(arr, temp, 0, array_size - 1);
	}

	public static int mergeSortHelper(int arr[], int temp[], int left, int right) {
		int mid, inv_count = 0;
		if (right > left) {

			mid = (right + left) / 2;

			inv_count = mergeSortHelper(arr, temp, left, mid);

			inv_count += mergeSortHelper(arr, temp, mid + 1, right);

			inv_count += MergeSortedArray(arr, temp, left, mid + 1, right);
		}
		return inv_count;
	}

	public static int MergeSortedArray(int arr[], int temp[], int left, int mid, int right) {
		int i, j, k;
		int inv_count = 0;

		i = left;
		j = mid;
		k = left;
		while ((i <= mid - 1) && (j <= right)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];

				inv_count = inv_count + (mid - i);
			}
		}

		while (i <= mid - 1)
			temp[k++] = arr[i++];

		while (j <= right)
			temp[k++] = arr[j++];

		for (i = left; i <= right; i++)
			arr[i] = temp[i];

		return inv_count;
	}

}
