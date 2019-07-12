package Arrays;

public class No46_Bit_Manipulations {

	public static void main(String[] args) {

		func(2, 96);

	}

	public static void func(int a, int b) {

		int size = Math.abs(b - a) + 1;

		int[] arr = new int[size];

		for (int i = a; i <= b; i++) {

			if (i % 2 == 0 || i % 5 == 0) {
				arr[i - a] = 1;

			}

		}

		System.out.println("MULTIPLES of 2" + " and 5:");

		for (int i = a; i <= b; i++) {

			if (arr[i - a] == 1) {
				System.out.print(i + " ");
			}

		}
	}

}
