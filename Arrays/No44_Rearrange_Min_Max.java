package Arrays;

public class No44_Rearrange_Min_Max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		System.out.print("Array\n");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		func(arr);

		System.out.println();
		System.out.print("\nModified Array\n");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public static void func(int[] arr) {

		int max = arr[arr.length - 1];
		int min = arr[0];

		for (int i = 0; i < arr.length; i++) {

			if (i % 2 == 0) {
				arr[i] = max;
				max -= 1;
			} else {
				arr[i] = min;
				min += 1;
			}
		}
	}

}
