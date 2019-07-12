package Matrix;

//https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/

public class No133_X_O_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };

		func(arr);
	}

	public static void func(int r, int c) {

		char[][] arr = new char[r][c];

		char x = 'X';

		char o = '0';

	}

	public static void func(int[][] a) {

		int i, k = 0, l = 0, m = 3, n = 6;
		/*
		 * k - starting row index m - ending row index l - starting column index n -
		 * ending column index i - iterator
		 */

		while (k < m && l < n) {
			// Print the first row from the remaining rows
			for (i = l; i < n; ++i) {
				System.out.print(a[k][i] + " ");
			}
			k++;

			// Print the last column from the remaining columns
			for (i = k; i < m; ++i) {
				System.out.print(a[i][n - 1] + " ");
			}
			n--;

			// Print the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					System.out.print(a[m - 1][i] + " ");
				}
				m--;
			}

			// Print the first column from the remaining columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					System.out.print(a[i][l] + " ");
				}
				l++;
			}

		}

	}
}
