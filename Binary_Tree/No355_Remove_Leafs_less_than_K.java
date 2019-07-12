package Binary_Tree;

import java.util.Stack;

public class No355_Remove_Leafs_less_than_K {

	class Node {
		int data;
		Node left;
		Node right;
	}

	static Node root;
	static int size;

	public No355_Remove_Leafs_less_than_K(int[] arr) {

		Stack<Node> stack = new Stack<No355_Remove_Leafs_less_than_K.Node>();

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

	public void remove(int k) {

		remove(root, 0, k);

	}

	private Node remove(Node node, int level, int k) {
		if (node == null) {
			return null;
		}

		node.left = remove(node.left, level + 1, k);
		node.right = remove(node.right, level + 1, k);

		if (node.left != null && node.right != null && level > k) {

			return null;

		}
		return node;
	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		// int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70,
		// -1, -1, 87, -1, -1, -1 };
		No355_Remove_Leafs_less_than_K bt = new No355_Remove_Leafs_less_than_K(arr);

		bt.display();

		System.out.println();

		bt.remove(2);

	}

}
