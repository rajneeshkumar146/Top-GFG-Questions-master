package Arrays;

//https://www.codechef.com/JAN18/problems/KCON/
public class No1_Kcon {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, -2, 1, 1, -2, 1 };

		func(arr);

	}

	public static void func(int[] arr) {

		int sum = arr[0];
		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (sum > 0) {
				sum += arr[i];
			} else {
				sum = arr[i];
			}

			if (sum > max) {
				max = sum;
			}

		}

		System.out.println(max);

	}

}
