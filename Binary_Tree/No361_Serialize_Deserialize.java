package Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class No361_Serialize_Deserialize {

	class Node {
		int data;
		Node left;
		Node right;
	}

	static Node root;
	static int size;

	public No361_Serialize_Deserialize(int[] arr) {

		Stack<Node> stack = new Stack<No361_Serialize_Deserialize.Node>();

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

	public void createArray() {

		ArrayList<Integer> idx = new ArrayList<Integer>();
		createArray(root, idx);
		idx.add(-1);

		System.out.println(idx);
	}

	private void createArray(Node node, ArrayList<Integer> idx) {

		if (node == null) {
			return;
		}

		idx.add(node.data);

		createArray(node.left, idx);

		createArray(node.right, idx);

		idx.add(-1);

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No361_Serialize_Deserialize bt = new No361_Serialize_Deserialize(arr);

		bt.display();

		System.out.println();

		bt.createArray();

		System.out.println();

	}

}
