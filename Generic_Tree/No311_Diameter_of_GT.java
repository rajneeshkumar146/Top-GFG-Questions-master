package Generic_Tree;

import java.util.ArrayList;
import java.util.Stack;

import july17.BinaryTree.diapair;

public class No311_Diameter_of_GT {

	class Node {
		int data;
		boolean locked = false;
		ArrayList<Node> children = new ArrayList<>();
	}

	Node root;
	int size = 0;

	public No311_Diameter_of_GT(int[] arr) {

		Stack<Node> stack = new Stack();

		for (int val : arr) {

			if (val != -1) {

				Node node = new Node();
				size++;
				node.data = val;

				if (stack.size() == 0) {
					root = node;
				} else {
					stack.peek().children.add(node);
				}

				stack.push(node);

			} else {
				stack.pop();
			}
		}

	}

	class Diapair {
		int height;
		int dia;

	}

	public void diameter() {

		diameter(root);

	}

	private Diapair diameter(Node node) {
		if (node == null) {

			Diapair bp = new Diapair();
			bp.height = -1;
			bp.dia = 0;
			return bp;
		}

		for (Node child : node.children) {

			Diapair cp = diameter(child);
		}

		Diapair mp = new Diapair();

		return mp;
	}
}
