package Binary_Tree;

import java.util.Stack;

public class No345_Deepest_Left_Node {

	class Node {
		Node left;
		Node right;
		int data;

	}

	static Node root;
	static int size = 0;

	public No345_Deepest_Left_Node(int[] arr) {
		Stack<Node> stack = new Stack<No345_Deepest_Left_Node.Node>();

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

	public void deepLeft(int key) {
		deepLeft(root, key, -1);
		System.out.println(result);

	}

	static int Max_level = -1;
	static int result = 0;

	private void deepLeft(Node node, int key, int level) {

		if (node == null) {
			return;
		}

		if (level > Max_level) {

			result = node.data;

			Max_level = level;

		}

		deepLeft(node.left, key, level + 1);
		deepLeft(node.right, key, level + 1);

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No345_Deepest_Left_Node bt = new No345_Deepest_Left_Node(arr);

		bt.display();

		System.out.println();

		bt.deepLeft(12);

	}

}
