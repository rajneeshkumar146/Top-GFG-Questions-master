package Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class No350_K_far_Nodes {

	class Node {
		Node left;
		Node right;
		int data;

	}

	static Node root;
	static int size = 0;

	public No350_K_far_Nodes(int[] arr) {
		Stack<Node> stack = new Stack<No350_K_far_Nodes.Node>();

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

	public void printK_far(int data, int k) {

		Node node = FindNode(root, data);

		printK_Down(node, k, 0);

		ArrayList<Node> list = NodeToRootPath(root, node);

		int size = list.size() - 2;

		int far = k - 1;

		while (far != 0) {

			PrintK_Far(list.get(size), list.get(size + 1), far, 0);
			far--;
		}

	}

	private void PrintK_Far(Node node, Node blocker, int far, int i) {
		if (node == null || node == blocker) {
			return;
		}

		if (far == i) {
			System.out.println(node.data);
			return;

		}

		PrintK_Far(node.left, blocker, far, i + 1);
		PrintK_Far(node.right, blocker, far, i + 1);

	}

	private ArrayList<Node> NodeToRootPath(Node node, Node find) {

		if (node == null) {
			ArrayList<Node> bres = new ArrayList<No350_K_far_Nodes.Node>();
			return bres;
		}

		if (node.data == find.data) {
			ArrayList<Node> ans = new ArrayList<No350_K_far_Nodes.Node>();
			ans.add(node);
			return ans;
		}

		ArrayList<Node> result = NodeToRootPath(node.left, find);

		if (result.size() > 0) {
			result.add(node);
			return result;
		}

		result = NodeToRootPath(node.right, find);

		if (result.size() > 0) {
			result.add(node);
			return result;
		}

		return result;
	}

	private Node FindNode(Node node, int data) {

		if (node == null) {
			return null;
		}

		if (node.data == data) {
			return node;
		}

		Node Findl = FindNode(node.left, data);

		if (Findl != null) {
			return Findl;
		}

		Node Findr = FindNode(node.right, data);
		if (Findr != null) {
			return Findr;
		}

		return null;
	}

	private void printK_Down(Node node, int k, int i) {
		if (node == null) {
			return;
		}

		if (i == k) {
			System.out.println(node.data);
			return;
		}

		printK_Down(node.left, k, i + 1);
		printK_Down(node.right, k, i + 1);
	}

	public static void main(String[] args) {

		// int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };

		No350_K_far_Nodes bt = new No350_K_far_Nodes(arr);

		bt.display();

		System.out.println();

		bt.printK_far(25, 2);

		System.out.println();

	}

}
