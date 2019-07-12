package Binary_Tree;

import java.util.Stack;

public class No320_Boundary_Traversal {

	class Node {
		int data;
		Node left;
		Node right;

	}

	Node root;

	int size = 0;

	public No320_Boundary_Traversal(int[] arr) {

		Stack<Node> stack = new Stack<No320_Boundary_Traversal.Node>();

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

	public void Boundary_Traversal() {

		Node node = this.root;

		if (node != null) {

			System.out.println(node.data);

			printLeft(node.left);

			printLeave(node.left);
			printLeave(node.right);

			printRight(node.right);

		}

	}

	private void printLeft(Node node) {

		if (node != null) {

			if (node.left != null) {

				System.out.println(node.data);

				printLeft(node.left);
			} else if (node.right != null) {

				System.out.println(node.data);

				printLeft(node.right);
			}

		}

	}

	private void printRight(Node node) {
		if (node != null) {

			if (node.right != null) {

				System.out.println(node.data);

				printRight(node.right);
			} else if (node.left != null) {

				System.out.println(node.data);

				printRight(node.left);
			}

		}

	}

	private void printLeave(Node node) {

		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			System.out.println(node.data + " ");
			return;
		}

		printLeave(node.left);

		printLeave(node.right);

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No320_Boundary_Traversal bt = new No320_Boundary_Traversal(arr);

		bt.display();

		System.out.println();

		bt.Boundary_Traversal();
	}
}