package Binary_Tree;

import java.util.Stack;

public class No346_Leaves_to_DLL {

	class Node {
		Node left;
		Node right;
		int data;

	}

	static Node root;
	static int size = 0;

	public No346_Leaves_to_DLL(int[] arr) {
		Stack<Node> stack = new Stack<No346_Leaves_to_DLL.Node>();

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

	public void Leaves_To_DLL() {

		Leaves_To_DLL(root);

		printDLL(head);

	}

	static Node head = null;
	static Node tail = head;

	private Node Leaves_To_DLL(Node node) {

		if (node.left == null && node.right == null) {
			if (head == null) {
				head = node;
				tail = node;
			} else {
				tail.right = node;
				node.left = tail;
				tail = node;

			}
			return null;
		}

		node.left = Leaves_To_DLL(node.left);
		node.right = Leaves_To_DLL(node.right);
		return node;
	}

	private void printDLL(Node node) {

		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.right;
		}

		System.out.println();

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No346_Leaves_to_DLL bt = new No346_Leaves_to_DLL(arr);

		bt.display();

		System.out.println();

		bt.Leaves_To_DLL();
		
		System.out.println();
		
		bt.display();
	}

}
