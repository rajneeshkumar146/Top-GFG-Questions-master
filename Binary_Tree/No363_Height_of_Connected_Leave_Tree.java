package Binary_Tree;

//https://www.geeksforgeeks.org/find-height-of-a-special-binary-tree-whose-leaf-nodes-are-connected/

public class No363_Height_of_Connected_Leave_Tree {

	class Node {
		int data;
		Node left;
		Node right;
	}

	static Node root;

	public int height() {

		return height_finder(root);
	}

	private int height_finder(Node node) {
		if (node == null) {
			return 0;
		}

		if (isleaf(node)) {
			return 1;
		}

		return (1 + height_finder(node.left) + height_finder(node.right));
	}

	private boolean isleaf(Node node) {
		return ((node.left != null && node.left.right == node) && (node.right != null && node.right.left == node));
	}
}
