package Binary_Tree;

public class No316_PreOrder_NoRecursion_MorrisTraversal {
	class Node {
		int data;
		Node left;
		Node right;
	}

	static Node root;

	public void preorder(Node root) {
	
		Node current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				Node predecessor = current.left;
				while (predecessor.right != current && predecessor.right != null) {
					predecessor = predecessor.right;
				}
				if (predecessor.right == null) {
					predecessor.right = current;
					System.out.print(current.data + " ");
					current = current.left;
				} else {
					predecessor.right = null;
					current = current.right;
				}
			}
		}
	}
}