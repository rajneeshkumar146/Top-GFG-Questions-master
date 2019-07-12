package Arrays;

public class No18_Biotonic_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 12, 4, 78, 90, 45, 23 };

		func(arr);

	}

	public static void func(int[] arr) {

		int[] inc = new int[arr.length];

		inc[0] = 1;

		for (int i = 1; i < arr.length; i++) {

			if (arr[i - 1] <= arr[i]) {

				inc[i] = inc[i - 1] + 1;
			} else {
				inc[i] = 1;
			}

		}

		int[] dec = new int[arr.length];

		dec[arr.length - 1] = 1;

		for (int j = arr.length - 2; j >= 0; j--) {

			if (arr[j + 1] <= arr[j]) {

				dec[j] = dec[j + 1] + 1;

			} else {
				dec[j] = 1;
			}

		}

		int res = inc[0] + dec[0] - 1;

		for (int i = 0; i < arr.length; i++) {

			res = Math.max(res, inc[i] + dec[i] - 1);

		}

		System.out.println(res);

	}

}
