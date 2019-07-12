package Binary_Tree;

import java.util.LinkedList;
import java.util.Stack;

public class No340_Width_of_Binary_Tree {

	class Node {
		Node left;
		Node right;
		int data;

	}

	static Node root;
	static int size = 0;

	public No340_Width_of_Binary_Tree(int[] arr) {
		Stack<Node> stack = new Stack<No340_Width_of_Binary_Tree.Node>();

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

	public int widthBetter() {

		LinkedList<Node> queue = new LinkedList<No340_Width_of_Binary_Tree.Node>();

		int max_size = 0;
		queue.addLast(root);

		while (queue.size() > 0) {

			if (max_size < queue.size()) {
				max_size = queue.size();
			}

			Node temp = queue.removeFirst();

			if (temp.left != null) {
				queue.addLast(temp.left);
			}

			if (temp.right != null) {
				queue.addLast(temp.right);
			}

		}
		return max_size;

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No340_Width_of_Binary_Tree bt = new No340_Width_of_Binary_Tree(arr);

		bt.display();

		System.out.println();

		System.out.println(bt.widthBetter());

		System.out.println();

	}

}
