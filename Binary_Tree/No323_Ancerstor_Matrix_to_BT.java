package Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;

public class No323_Ancerstor_Matrix_to_BT {

	class Node {
		Node left;
		Node right;
		int data;
	}

	static Node root;

	static int size;

	public void makeBT(int[][] matrix) {

		HashMap<Integer, Node> map = new HashMap<Integer, No323_Ancerstor_Matrix_to_BT.Node>();

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix.length; j++) {

				if (matrix[i][j] == 1) {
					Node p = new Node();

					if (!map.containsKey(i)) {
						p.data = i;
					} else {
						p = map.get(i);
					}

					Node c = new Node();
					c.data = j;

					if (p.left == null) {
						p.left = c;
					} else {
						p.right = c;
					}

					map.put(i, p);

				}

			}
		}

		ArrayList<Integer> arr = new ArrayList<Integer>(map.keySet());

		for (int i = 0; i < arr.size(); i++) {

			System.out.print(map.get(arr.get(i)).left.data + " ");

			System.out.print(map.get(arr.get(i)).data + " ");

			System.out.print(map.get(arr.get(i)).right.data + " ");

			System.out.println();

		}

	}

	static int myidx;

	public static void main(String[] args) {

		int[][] matrix = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0 }, { 0, 0, 1, 0, 0, 1, 0 } };

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		No323_Ancerstor_Matrix_to_BT bt = new No323_Ancerstor_Matrix_to_BT();

		System.out.println();
		bt.makeBT(matrix);

	}

}
