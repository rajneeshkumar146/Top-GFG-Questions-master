package String;

import java.util.Arrays;

public class No80_Min_Array_ {

	public static void main(String[] args) {

		String str = "aabcbcdbca";

		func(str);

	}

	public static void func(String str) {

		int max = 256;
		int n = str.length();

		int dist = 0;

		boolean[] arr = new boolean[max];

		Arrays.fill(arr, false);

		for (int i = 0; i < n; i++) {

			if (arr[str.charAt(i)] == false) {
				arr[str.charAt(i)] = true;
				dist++;
			}

		}

	}

}
