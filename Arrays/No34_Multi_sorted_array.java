package Arrays;

//https://www.geeksforgeeks.org/generate-all-possible-sorted-arrays-from-alternate-elements-of-two-given-arrays/

public class No34_Multi_sorted_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void func(int[] arr, int[] arr2) {
		
		

	}

	public static boolean isSorted(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
