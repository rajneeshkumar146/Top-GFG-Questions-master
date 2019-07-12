package Arrays;

//https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/

public class No11_Rotate_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		rotmat(mat);

		displayMatrix(mat);

	}

	public static void displayMatrix(int mat[][]) {

		int n = mat[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(" " + mat[i][j]);

			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void rotmat(int mat[][]) {

		int n = mat[0].length;

		for (int i = 0; i < n / 2; i++) {

			for (int j = i; j < n - i - 1; j++) {

				int k = mat[i][j];

				mat[i][j] = mat[j][n - 1 - i];

				mat[j][n - 1 - i] = mat[n - 1 - i][n - 1 - j];

				mat[n - 1 - i][n - 1 - j] = mat[n - 1 - j][i];

				mat[n - 1 - j][i] = k;

			}
		}

	}

}
