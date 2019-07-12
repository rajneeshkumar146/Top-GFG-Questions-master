package Generic_Tree;

import java.util.ArrayList;

public class No306_Kth_preoderTree {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 5, 6, 7, 3, 8, 9, 10, 4 };
		int k = 3;

		No306_Kth_preoderTree tree = new No306_Kth_preoderTree(arr, k);
		tree.display();
	}

	class Node {

		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	Node root;
	int size = 0;

	public No306_Kth_preoderTree(int[] arr, int k) {

		int height = (int) Math.ceil(Math.log(arr.length) / Math.log(k));
		System.out.println(height);

		root = helper(arr, height, k);

	}

	static int idx = 0;

	private Node helper(int[] arr, int height, int k) {

		if (height == 0)
			return null;

		if (idx == arr.length)
			return null;

		Node node = new Node();
		node.data = arr[idx];
		idx++;

		for (int i = 0; i < k; i++) {

			Node child = helper(arr, height - 1, k);

			if (child != null)
				node.children.add(child);
		}

		return node;

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		String str = node.data + " : -  ";

		for (Node child : node.children) {
			str = str + child.data + " , ";
		}

		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}

	}

}
