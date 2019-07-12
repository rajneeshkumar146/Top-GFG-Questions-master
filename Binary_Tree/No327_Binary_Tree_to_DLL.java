package Binary_Tree;

import java.util.Stack;

public class No327_Binary_Tree_to_DLL {

	class Node {
		Node left;
		Node right;
		int data;
	}

	static Node root;

	static int size;

	public No327_Binary_Tree_to_DLL(int[] arr) {
		Stack<Node> stack = new Stack<No327_Binary_Tree_to_DLL.Node>();

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

	Node head = new Node();

	static Node prev = null;

	public void BTtoDLL() {

		BTtoDLL(root);

		printDLL(head);
	}

	private void BTtoDLL(Node node) {

		if (node == null) {
			return;
		}

		BTtoDLL(node.left);

		if (prev == null) {
			head = node;
		} else {
			prev.right = node;
			root.left = prev;
		}
		prev = node;

		BTtoDLL(node.right);

	}

	private void printDLL(Node node) {

		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.right;
		}

		System.out.println();

	}

	public static void main(String[] args) {

		int[] arr = { 7, 6, 5, -1, 4, -1, -1, 3, 2, -1, 1, -1, -1, -1 };

		No327_Binary_Tree_to_DLL bt = new No327_Binary_Tree_to_DLL(arr);

		bt.display();

		System.out.println();

		bt.BTtoDLL();

		System.out.println();

	}

}
