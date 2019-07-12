package Arrays;

//https://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/

public class No15_Max_Value_Rotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 8, 3, 1, 2 };

		System.out.println(maxSum(arr, arr.length));

	}

	static int maxSum(int arr[], int n) {
		
		int sum = 0;
		
		int i;
		
		int pivot = findPivot(arr, n);

		int diff = n - 1 - pivot;

		for (i = 0; i < n; i++) {
			sum = sum + ((i + diff) % n) * arr[i];
		}
		
		return sum;
	}

	static int findPivot(int arr[], int n) {
		int i;
		for (i = 0; i < n; i++) {
			if (arr[i] > arr[(i + 1) % n])
				return i;
		}
		return 0;
	}

}
