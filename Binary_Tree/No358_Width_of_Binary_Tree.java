package Binary_Tree;

import java.util.Stack;

public class No358_Width_of_Binary_Tree {

	class Node {
		int data;
		Node left;
		Node right;
	}

	static Node root;
	static int size;

	public No358_Width_of_Binary_Tree(int[] arr) {

		Stack<Node> stack = new Stack<No358_Width_of_Binary_Tree.Node>();

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

	public int width() {

		width(root, 0);

		return (1 + Math.abs(min) + max);

	}

	static int max = 0;
	static int min = 0;

	private void width(Node node, int vc) {

		if (node == null) {
			return;
		}

		if (vc > max) {
			max = vc;
		}

		if (min > vc) {
			min = vc;
		}

		width(node.left, vc - 1);
		width(node.right, vc + 1);

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		// int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70,
		// -1, -1, 87, -1, -1, -1 };
		No358_Width_of_Binary_Tree bt = new No358_Width_of_Binary_Tree(arr);

		bt.display();

		System.out.println();

		System.out.println(bt.width());

		System.out.println();

	}

}
