package Binary_Tree;

public class No336_Populate_Inorder_Successor {

	class Node {
		Node next;
		Node left;
		Node right;
	}

	static Node root;

	Node temp = null;

	public void Populate_Inorder_Successor() {

		Populate_Inorder_Successor(root);

	}

	private void Populate_Inorder_Successor(Node node) {
		if (node == null) {
			return;
		}
		
		
		Populate_Inorder_Successor(node.right);
		
		node.next = temp;
		
		temp = node;
		
		Populate_Inorder_Successor(node.left);
	}

}
