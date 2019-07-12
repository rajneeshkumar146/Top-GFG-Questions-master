package Binary_Tree;

import java.util.HashMap;
import java.util.Stack;

public class No343_Vertical_Sum {

	class Node {
		Node left;
		Node right;
		int data;

	}

	static Node root;
	static int size = 0;

	public No343_Vertical_Sum(int[] arr) {
		Stack<Node> stack = new Stack<No343_Vertical_Sum.Node>();

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

	public void verticalSum() {

		verticalSum(root, 0);

		System.out.println(map);

	}

	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	private void verticalSum(Node node, int vc) {

		if (node == null) {
			return;
		}

		if (map.containsKey(vc)) {
			int value = map.get(vc);
			map.put(vc, value + node.data);
		} else {
			map.put(vc, node.data);
		}

		verticalSum(node.left, vc - 1);
		verticalSum(node.right, vc + 1);

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No343_Vertical_Sum bt = new No343_Vertical_Sum(arr);

		bt.display();

		System.out.println();

		bt.verticalSum();

		System.out.println();

	}

}
