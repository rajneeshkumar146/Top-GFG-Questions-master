package Arrays;

//https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

public class No36_Arr_J_I_DIff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };

		func(arr);

	}

	public static int max(int x, int y) {
		return x > y ? x : y;
	}

	public static int min(int x, int y) {
		return x < y ? x : y;
	}

	public static void func(int[] arr) {

		int n = arr.length;
		int maxDiff;
		int i, j;

		int RMax[] = new int[n];
		int LMin[] = new int[n];

		LMin[0] = arr[0];
		for (i = 1; i < n; ++i)
			LMin[i] = min(arr[i], LMin[i - 1]);

		RMax[n - 1] = arr[n - 1];
		for (j = n - 2; j >= 0; --j)
			RMax[j] = max(arr[j], RMax[j + 1]);

		i = 0;
		j = 0;
		maxDiff = -1;
		while (j < n && i < n) {
			if (LMin[i] < RMax[j]) {
				maxDiff = max(maxDiff, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}

		System.out.println(maxDiff);

	}

}
