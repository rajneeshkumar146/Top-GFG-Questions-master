package Binary_Tree;

import java.util.Stack;

public class No329_Left_SubTree_sum {

	class Node {
		int data;
		Node left;
		Node right;

	}

	Node root;

	int size = 0;

	public No329_Left_SubTree_sum(int[] arr) {

		Stack<Node> stack = new Stack<No329_Left_SubTree_sum.Node>();

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

	public void LeftSumTree() {

		LeftSumTree(root);

	}

	public int LeftSumTree(Node node) {

		if (node.left == null && node.right == null) {
			return node.data;
		}

		int ls = LeftSumTree(node.left);
		int rs = LeftSumTree(node.right);

		node.data += ls;

		return node.data + rs;

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No329_Left_SubTree_sum bt = new No329_Left_SubTree_sum(arr);

		bt.display();

		System.out.println();

		bt.LeftSumTree();

		System.out.println();

		bt.display();
	}
}
