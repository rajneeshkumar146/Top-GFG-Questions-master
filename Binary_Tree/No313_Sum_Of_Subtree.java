package Binary_Tree;

import java.util.Stack;

public class No313_Sum_Of_Subtree {
	class Node {
		int data;
		Node left;
		Node right;

	}

	Node root;

	int size = 0;

	static int ctr;

	public No313_Sum_Of_Subtree(int[] arr) {

		Stack<Node> stack = new Stack<Node>();

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

	public void subTreeSumCtr(int x) {

		subTreeSumCtr(root, x);
		System.out.println(ctr);

	}

	public int subTreeSumCtr(Node node, int x) {

		if (node == null) {
			return 0;
		}

		int ls = subTreeSumCtr(node.left, x);
		int rs = subTreeSumCtr(node.right, x);

		int sum = ls + rs + node.data;

		if (sum >= x) {
			ctr++;
		}

		return sum;

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No313_Sum_Of_Subtree bt = new No313_Sum_Of_Subtree(arr);

		bt.display();

		System.out.println();

		bt.subTreeSumCtr(50);

	}
}
