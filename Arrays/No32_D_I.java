package Arrays;

//https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/

import java.util.ArrayList;

public class No32_D_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "DDIDDIID";

		func(str);
	}

	public static void func(String str) {

		int[] temp = new int[str.length()];

		int dctr = 0;
		int dstart = 0;

		int ictr = 0;
		int istart = 0;

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == 'D') {

				if (ictr > 0) {

					temp[istart] = ictr;
					istart = 0;
					ictr = 0;

				}

				if (dctr == 0) {
					dctr++;
					dstart = i;
				} else {
					dctr++;
				}

			} else if (str.charAt(i) == 'I') {

				if (dctr > 0) {

					temp[dstart] = -dctr;
					dstart = 0;
					dctr = 0;

				}

				if (ictr == 0) {
					ictr++;
					istart = i;
				} else {
					ictr++;
				}

			}
		}

		if (ictr > 0) {
			temp[istart] = ictr;
		}

		if (dctr > 0) {
			temp[dstart] = -dctr;
		}

		for (int x : temp) {
			System.out.print(x + " ");
		}

		System.out.println();

		ArrayList<Integer> ans = new ArrayList<>();

	}

}
