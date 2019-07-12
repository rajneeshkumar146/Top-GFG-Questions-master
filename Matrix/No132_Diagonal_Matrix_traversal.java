package Matrix;

//https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/

public class No132_Diagonal_Matrix_traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 }, };

		System.out.print("Given matrix is");
		System.out.println();
		printMatrix(mat);

		System.out.println();
		func(mat);

	}

	public static void func(int[][] mat) {
		final int r_size = mat.length;
		final int c_size = mat[0].length;

		for (int i = 1; i < (mat.length + mat[0].length) - 1; i++) {

			int start_col = Math.max(0, i - r_size);

			int count = min(i, (c_size - start_col), r_size);

			for (int x = 0; x < count; x++) {
				System.out.print(mat[Math.min(r_size, i) - x - 1][start_col + x] + " ");

			}
			System.out.println();

		}

	}

	static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	static void printMatrix(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.print("\n");
		}
	}
}
