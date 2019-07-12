package Binary_Tree;

import java.util.HashMap;
import java.util.Stack;

public class No319_Vertical_Order_Traversal {

	class Node {
		Node left;
		Node right;
		int data;
	}

	static int min;
	static int max;
	static Node root;
	static int size;

	public No319_Vertical_Order_Traversal(int[] arr) {

		Stack<Node> stack = new Stack<No319_Vertical_Order_Traversal.Node>();

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

	private void setminmax(Node root, int vf) {

		if (root == null) {
			return;
		}

		min = Math.min(vf, min);
		max = Math.max(vf, max);

		setminmax(root.left, vf - 1);
		setminmax(root.right, vf + 1);

	}

	public void verticalOrderTraversal() {

		setminmax(root, 0);

		for (int i = min; i <= max; i++) {

			verticalOrderTraversal(root, 0, i);
			System.out.println();
		}
	}

	private void verticalOrderTraversal(Node node, int vf, int i) {

		if (node == null) {
			return;
		}

		if (i == vf) {
			System.out.print(node.data + " ");
		}

		verticalOrderTraversal(node.left, vf - 1, i);
		verticalOrderTraversal(node.right, vf + 1, i);
	}

	static HashMap<Integer, String> map = new HashMap<Integer, String>();

	public void verticalOrderMap() {

		verticalOrderMap(root, 0);

		System.out.println(map);

	}

	private void verticalOrderMap(Node node, int vf) {

		if (node == null) {
			return;
		}

		if (map.containsKey(vf)) {
			map.put(vf, map.get(vf) + node.data + " ");
		} else {
			map.put(vf, node.data + " ");
		}

		verticalOrderMap(node.left, vf - 1);
		verticalOrderMap(node.right, vf + 1);

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No319_Vertical_Order_Traversal bt = new No319_Vertical_Order_Traversal(arr);

		bt.display();

		System.out.println();

		bt.verticalOrderMap();

		System.out.println();

		bt.verticalOrderTraversal();

	}
}
