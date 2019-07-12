package Arrays;

public class No42_Reorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 10, 11, 12 };
		int index[] = new int[] { 1, 0, 2 };

		func(arr, index);

	}

	public static void func(int[] arr, int[] index) {

		for (int i = 0; i < arr.length; i++) {

			while (index[i] != i) {

				int oldV = arr[index[i]];
				int oldI = index[index[i]];

				arr[index[i]] = arr[i];
				index[index[i]] = index[i];

				arr[i] = oldV;
				index[i] = oldI;

			}

		}

		for (int x : arr) {
			System.out.print(x + " ");
		}

		System.out.println();

		for (int y : index) {
			System.out.print(y + "  ");
		}

	}

}
