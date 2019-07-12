package Binary_Tree;

import java.util.Stack;

public class No339_Foldable_Binary_Tree {

	class Node {
		Node left;
		Node right;
		int data;
	}

	static int size;
	static Node root;

	public No339_Foldable_Binary_Tree(int[] arr) {
		Stack<Node> stack = new Stack<No339_Foldable_Binary_Tree.Node>();

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

	public boolean isfoldable() {

		return isfoldable(root, root, 0, 0);

	}

	private boolean isfoldable(Node left, Node right, int vl, int vr) {

		if (left == null || right == null) {
			return true;
		}

		if (isfoldable(left.left, right.right, vl - 1, vr + 1) == false) {
			return false;
		}

		if (isfoldable(left.right, right.left, vl + 1, vr - 1) == false) {
			return false;
		}

		if (Math.abs(vl) == Math.abs(vr)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No339_Foldable_Binary_Tree bt = new No339_Foldable_Binary_Tree(arr);

		bt.display();

		System.out.println();

		System.out.println(bt.isfoldable());

		System.out.println();

	}

}
