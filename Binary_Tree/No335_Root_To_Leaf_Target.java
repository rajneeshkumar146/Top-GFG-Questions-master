package Binary_Tree;

import java.util.Stack;

public class No335_Root_To_Leaf_Target {
	class Node {
		Node left;
		Node right;
		int data;
	}

	static Node root;

	static int size;

	public No335_Root_To_Leaf_Target(int[] arr) {
		Stack<Node> stack = new Stack<No335_Root_To_Leaf_Target.Node>();

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

	public boolean RootToNodeTarget(int tar) {

		return RootToNodeTarget(root, tar, 0);
	}

	private boolean RootToNodeTarget(Node node, int tar, int sum) {

		if (node == null) {
			if (tar == sum) {
				return true;
			}
			return false;
		}

		if (RootToNodeTarget(node.left, tar, sum + node.data) || RootToNodeTarget(node.right, tar, sum + node.data)) {
			return true;
		}

		return false;

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No335_Root_To_Leaf_Target bt = new No335_Root_To_Leaf_Target(arr);

		bt.display();

		System.out.println();

		System.out.println(bt.RootToNodeTarget(212));

	}
}
