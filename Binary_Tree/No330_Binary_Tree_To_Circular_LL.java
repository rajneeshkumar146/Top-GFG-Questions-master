package Binary_Tree;

import java.util.Stack;

public class No330_Binary_Tree_To_Circular_LL {
	class Node {
		Node left;
		Node right;
		int data;
	}

	static Node root;

	static int size;

	public No330_Binary_Tree_To_Circular_LL(int[] arr) {
		Stack<Node> stack = new Stack<No330_Binary_Tree_To_Circular_LL.Node>();

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

	public void BTtoCDLL() {

		BTtoCDLL(root);

		makeCircle(head);

		printCDLL(head);
	}

	private void printCDLL(Node node) {

		while (node.right != head) {

			System.out.print(node.data + "->");

			node = node.right;
		}

		System.out.print(node.data);
		System.out.println();

	}

	private void BTtoCDLL(Node node) {

		if (node == null) {
			return;
		}

		BTtoCDLL(node.left);

		if (prev == null) {
			head = node;
		} else {
			prev.right = node;
			root.left = prev;
		}
		prev = node;

		BTtoCDLL(node.right);

	}

	private void makeCircle(Node node) {

		while (node.right != null) {
			node = node.right;
		}

		head.left = node;
		node.right = head;

	}

	public static void main(String[] args) {

		int[] arr = { 7, 6, 5, -1, 4, -1, -1, 3, 2, -1, 1, -1, -1, -1 };

		No330_Binary_Tree_To_Circular_LL bt = new No330_Binary_Tree_To_Circular_LL(arr);

		bt.display();

		System.out.println();

		bt.BTtoCDLL();

		System.out.println();

	}

}
