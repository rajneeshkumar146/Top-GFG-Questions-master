package Binary_Tree;

import java.util.Stack;

import javax.swing.text.MaskFormatter;

public class No342_Max_Sum_Path {

	class Node {
		Node left;
		Node right;
		int data;

	}

	static Node root;
	static int size = 0;

	public No342_Max_Sum_Path(int[] arr) {
		Stack<Node> stack = new Stack<No342_Max_Sum_Path.Node>();

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

	public int MaxSumPath() {

		MaxSumPath(root, 0);
		return max;
	}

	static int max = Integer.MIN_VALUE;

	private void MaxSumPath(Node node, int sum) {

		if (node == null) {

			if (sum > max) {
				max = sum;
			}
			return;
		}

		MaxSumPath(node.left, sum + node.data);
		MaxSumPath(node.right, sum + node.data);

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No342_Max_Sum_Path bt = new No342_Max_Sum_Path(arr);

		bt.display();

		System.out.println();

		System.out.println(bt.MaxSumPath());

		System.out.println();

	}

}
