package Binary_Tree;

public class No322_Special_Tree_PreOrder_Traversal {
	class Node {
		int data;
		Node left;
		Node right;
	}

	static int size;
	static Node root;

	static int myidx = 0;

	public void SpecialTree(int[] Pre_values, char[] Pre_nodes) {

		root = SpecialTreehelper(Pre_values, Pre_nodes, myidx, Pre_values.length, root);

	}

	private Node SpecialTreehelper(int[] pre_values, char[] pre_nodes, int myidx, int length, Node node) {

		if (myidx == length) {
			return null;
		}

		node = new Node();
		node.data = pre_values[myidx];
		myidx++;

		if (pre_nodes[myidx] == 'N') {

			node.left = SpecialTreehelper(pre_values, pre_nodes, myidx, length, node.left);

			node.right = SpecialTreehelper(pre_values, pre_nodes, myidx, length, node.right);
		}
		return node;
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

	public static void main(String[] args) {

		int[] Pre_values = new int[] { 10, 30, 20, 5, 15 };
		char[] Pre_nodes = { 'N', 'N', 'L', 'L', 'L' };

		No322_Special_Tree_PreOrder_Traversal bt = new No322_Special_Tree_PreOrder_Traversal();

		bt.SpecialTree(Pre_values, Pre_nodes);

		bt.display();

	}
}
