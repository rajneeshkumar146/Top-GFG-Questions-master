package Binary_Tree;

import java.util.Stack;

public class No344_Right_Node_of_key {

	class Node {
		Node left;
		Node right;
		int data;

	}

	static Node root;
	static int size = 0;

	public No344_Right_Node_of_key(int[] arr) {
		Stack<Node> stack = new Stack<No344_Right_Node_of_key.Node>();

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

	public void RightNode(int key) {
		RightNoderHelper(root, key, -1);

		if (search == true) {
			System.out.println("Null");
		}
	}

	static int Found_level = 0;
	static boolean search = false;

	private void RightNoderHelper(Node node, int key, int level) {

		if (node == null) {
			return;
		}

		if (search && Found_level == level) {
			System.out.println(node.data);
			search = false;
		}

		if (node.data == key) {
			search = true;
			Found_level = level;
		}

		RightNoderHelper(node.left, key, level + 1);
		RightNoderHelper(node.right, key, level + 1);

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No344_Right_Node_of_key bt = new No344_Right_Node_of_key(arr);

		bt.display();

		System.out.println();

		bt.RightNode(12);

	}

}
