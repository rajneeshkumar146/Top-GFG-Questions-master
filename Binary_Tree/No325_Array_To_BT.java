package Binary_Tree;

public class No325_Array_To_BT {

	class Node {
		Node left;
		Node right;
		int data;

	}

	static Node root;

	public void createTree(int[] parent, int n) {

		Node[] node = new Node[n];

		for (int i = 0; i < n; i++) {
			node[i] = null;
		}

		for (int i = 0; i < n; i++) {
			createTree(parent, i, node);
		}

	}

	private void createTree(int[] parent, int i, Node[] node) {

		if (node[i] != null) {
			return;
		}

		node[i] = new Node();
		node[i].data = i;

		if (parent[i] == -1) {
			root = node[i];
			return;
		}

		if (node[parent[i]] == null) {
			createTree(parent, i, node);
		}

		Node p = node[parent[i]];

		if (p.left == null) {
			p.left = node[i];
		} else {
			p.right = node[i];
		}

	}

	public static void main(String[] args) {

		int parent[] = new int[] { -1, 0, 0, 1, 1, 3, 5 };
		int n = parent.length;

		No325_Array_To_BT bt = new No325_Array_To_BT();

		bt.createTree(parent, n);

	}

}
