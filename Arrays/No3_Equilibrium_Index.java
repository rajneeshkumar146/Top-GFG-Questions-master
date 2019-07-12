package Arrays;

public class No3_Equilibrium_Index {

	public static void main(String[] args) {
		int[] a = { -7, 1, 5, 2, -4, 3, 0 };

		System.out.println(equilibrium(a));

	}

	private static int equilibrium(int[] arr) {

		int sum = 0;
		int leftsum = 0;
		int n = arr.length;

		for (int i = 0; i < n; ++i) {
			sum += arr[i];
		}

		for (int i = 0; i < n; ++i) {
			sum -= arr[i];

			if (leftsum == sum)
				return i;

			leftsum += arr[i];
		}

		return -1;

	}

}
