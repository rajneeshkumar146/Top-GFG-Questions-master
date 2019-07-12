package Binary_Tree;

import java.util.HashMap;
import java.util.Stack;

public class No318_Diagonal_Traversal {

	class Node {
		int data;
		Node left;
		Node right;
	}

	static Node root;
	static int size;

	public No318_Diagonal_Traversal(int[] arr) {

		Stack<Node> stack = new Stack<No318_Diagonal_Traversal.Node>();

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

	static HashMap<Integer, String> map = new HashMap<Integer, String>();

	public void Diagonal_Traversal() {

		Diagonal_Traversal(root, 0);
		System.out.println(map);

	}

	private void Diagonal_Traversal(Node node, int dc) {
		if (node == null) {
			return;
		}

		if (!map.containsKey(dc)) {

			map.put(dc, node.data + " ");

		} else {
			String temp = map.get(dc);

			temp += node.data + " ";

			map.put(dc, temp);
		}

		Diagonal_Traversal(node.left, dc + 1);
		Diagonal_Traversal(node.right, dc);
	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		// int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70,
		// -1, -1, 87, -1, -1, -1 };
		No318_Diagonal_Traversal bt = new No318_Diagonal_Traversal(arr);

		bt.display();

		System.out.println();

		bt.Diagonal_Traversal();

	}

}
