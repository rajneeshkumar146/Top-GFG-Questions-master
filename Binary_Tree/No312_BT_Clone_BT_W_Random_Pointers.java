package Binary_Tree;

import java.util.HashMap;
import java.util.Stack;

public class No312_BT_Clone_BT_W_Random_Pointers {

	class Node {
		int data;
		Node left;
		Node right;
		Node Random;
	}

	Node root;

	int size = 0;

	public No312_BT_Clone_BT_W_Random_Pointers(int[] arr) {

		Stack<Node> stack = new Stack<No312_BT_Clone_BT_W_Random_Pointers.Node>();

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

	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	Node clone_node = new Node();

	public No312_BT_Clone_BT_W_Random_Pointers cloner() {

		Node og_node = this.root;

		cloner(og_node, clone_node);

		int[] arr = { 0 };

		No312_BT_Clone_BT_W_Random_Pointers clone = new No312_BT_Clone_BT_W_Random_Pointers(arr);

		clone.root = clone_node;

		randomsetter(clone_node);

		return clone;
	}

	private void cloner(Node og_node, Node clone_node) {

		map.put(og_node.data, 69);

		clone_node.data = og_node.data;

		if (og_node.left != null) {
			Node ln = new Node();
			clone_node.left = ln;
			cloner(og_node.left, ln);
		}

		if (og_node.right != null) {
			Node rn = new Node();
			clone_node.right = rn;
			cloner(og_node.right, rn);
		}

	}

	private void randomsetter(Node clone_node) {

		if (clone_node == null) {
			return;
		}

//		clone_node.Random = findNode(map.get(clone_node.data));

		randomsetter(clone_node.left);

		randomsetter(clone_node.right);

	}

	public Node findNode(int data) {

		return findNode(clone_node, data);
	}

	private Node findNode(Node node, int data) {
		if (node == null) {
			return null;
		}

		if (data == node.data) {
			return node;
		}

		Node ans = findNode(node.left, data);
		if (ans != null) {
			return ans;
		}

		Node ans2 = findNode(node.right, data);
		if (ans2 != null) {
			return ans2;
		}
		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };
		No312_BT_Clone_BT_W_Random_Pointers bt = new No312_BT_Clone_BT_W_Random_Pointers(arr);

		bt.display();

		No312_BT_Clone_BT_W_Random_Pointers clone = bt.cloner();

		System.out.println();
		clone.display();

	}

}
