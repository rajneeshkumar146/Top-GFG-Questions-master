package Binary_Tree;

import java.util.LinkedList;
import java.util.Stack;

public class No321_LevelOrder_Traversal {
	class Node {
		int data;
		Node left;
		Node right;
	}

	static Node root;
	static int size;

	public No321_LevelOrder_Traversal(int[] arr) {

		Stack<Node> stack = new Stack<No321_LevelOrder_Traversal.Node>();

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

	public void levelOrder() {

		LinkedList<Node> queue = new LinkedList<No321_LevelOrder_Traversal.Node>();

		queue.addLast(root);

		while (queue.size() > 0) {

			Node node = queue.removeFirst();

			System.out.print(node.data + " ");

			if (node.left != null) {
				queue.addLast(node.left);
			}
			if (node.right != null) {
				queue.addLast(node.right);
			}
		}

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No321_LevelOrder_Traversal bt = new No321_LevelOrder_Traversal(arr);

		bt.display();

		System.out.println();
		bt.levelOrder();
	}

}
