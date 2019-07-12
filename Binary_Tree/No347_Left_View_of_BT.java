package Binary_Tree;

import java.util.Stack;

public class No347_Left_View_of_BT {

	class Node {
		Node left;
		Node right;
		int data;

	}

	static Node root;
	static int size = 0;

	public No347_Left_View_of_BT(int[] arr) {
		Stack<Node> stack = new Stack<No347_Left_View_of_BT.Node>();

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

	public void Left_View() {
		Left_View(root, -1);
	}

	static int Max_level = -1;

	private void Left_View(Node node, int level) {

		if (node == null) {
			return;
		}

		if (level > Max_level) {
			System.out.println(node.data);

			Max_level = level;
		}

		Left_View(node.left, level + 1);
		Left_View(node.right, level + 1);

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No347_Left_View_of_BT bt = new No347_Left_View_of_BT(arr);

		bt.display();

		System.out.println();

		bt.Left_View();
	}

}
