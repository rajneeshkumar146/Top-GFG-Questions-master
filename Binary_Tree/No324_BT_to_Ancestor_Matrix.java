package Binary_Tree;

import java.util.Stack;

public class No324_BT_to_Ancestor_Matrix {

	class Node {
		int data;
		Node left;
		Node right;
	}

	static int size;
	static Node root;

	public No324_BT_to_Ancestor_Matrix(int[] arr) {
		Stack<Node> stack = new Stack<No324_BT_to_Ancestor_Matrix.Node>();

		for (int val : arr) {

			if (val == -1) {
				stack.pop();
			} else {
				Node node = new Node();
				node.data = val;

				size++;

				if (stack.size() == 0) {
					root = node;
				}

				if (stack.size() > 0) {
					if (stack.peek().left == null) {
						stack.peek().left = node;

					} else {
						stack.peek().right = node;
					}
				}

				stack.push(node);
			}

		}
	}

	public void display() {

		display(root);

	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = new String();

		str += node.left != null ? node.left.data : ".";

		str += "<- " + node.data + " -> ";

		str += node.right != null ? node.right.data : ".";

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public void BT_To_Martix() {

		int n = CountNode(root);

		int[][] matrix = new int[n + 1][n + 1];

		BT_To_Martix(root, matrix);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	private void BT_To_Martix(Node node, int[][] matrix) {

		if (node == null) {
			return;
		}

		BT_To_Martix(node.left, matrix);
		BT_To_Martix(node.right, matrix);

		if (node.left != null) {

			matrix[node.data][node.left.data] = 1;

		}

		if (node.right != null) {

			matrix[node.data][node.right.data] = 1;

		}
	}

	private int CountNode(Node node) {
		if (node == null) {
			return 0;
		}

		return CountNode(node.left) + CountNode(node.right) + 1;
	}

	public static void main(String[] args) {

		int[] arr = { 7, 6, 5, -1, 4, -1, -1, 3, 2, -1, 1, -1, -1, -1 };

		No324_BT_to_Ancestor_Matrix bt = new No324_BT_to_Ancestor_Matrix(arr);

		bt.display();

		System.out.println();

		bt.BT_To_Martix();

		System.out.println();

	}

}
