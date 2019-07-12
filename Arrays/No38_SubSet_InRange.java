package Arrays;

public class No38_SubSet_InRange {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 0, 11, 3, 0 };
		
		func(arr, 1, 10);
		funcer(arr, 1, 10);

	}

	private static void func(int[] arr, int lo, int hi) {

		int exc = 0;
		int inc = 0;
		int res = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > hi) {
				res += (countSubSet(exc) - countSubSet(inc));
				inc = 0;
				exc = 0;
			} else if (arr[i] < lo) {
				inc++;
				exc++;

			} else {
				res = res - countSubSet(exc);
				exc = 0;
				inc++;
			}

		}
		res += (countSubSet(inc) - countSubSet(exc));

		System.out.println(res);
	}

	private static void funcer(int[] arr, int lo, int hi) {

		int b = 0;
		int s = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] <= hi) {
				b++;
			}

			if (arr[i] <= lo) {
				s++;
			}

		}

		System.out.println(countSubSet(b) - countSubSet(s));

	}

	public static int countSubSet(int x) {
		return x * (x + 1) / 2;
	}

}
