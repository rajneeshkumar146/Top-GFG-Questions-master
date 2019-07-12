package Binary_Search_Tree;

public class No364_BST_from_PreOrder {

	class Node {
		int data;
		Node left;
		Node right;
	}

	Node root;
	static int idx = 0;

	public void PreToBST(int[] pre) {

		this.root = PreToBSTHelper(pre, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, pre.length);

	}

	private Node PreToBSTHelper(int[] pre, int data, int min, int max, int size) {

		if (idx >= size) {
			return null;
		}

		Node node = null;

		if (data > min && data < max) {

			node = new Node();
			node.data = data;
			idx++;

			if (idx < size) {

				node.left = PreToBSTHelper(pre, pre[idx], min, data, size);

				node.right = PreToBSTHelper(pre, pre[idx], data, max, size);
			}
		}

		return node;

	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);

		System.out.print(node.data + " ");

		inOrder(node.right);

	}

	public void Display() {
		display(root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = " ";

		str += node.left == null ? " -1 - >" : node.left.data + " -> ";

		str += node.data;

		str += node.right == null ? "< - -1 " : " < - " + node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public static void main(String[] args) {

		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };

		No364_BST_from_PreOrder bst = new No364_BST_from_PreOrder();

		bst.PreToBST(pre);

		bst.Display();

		System.out.println();

		bst.inOrder();

	}
}
