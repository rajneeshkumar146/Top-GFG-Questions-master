package Binary_Tree;

import java.util.*;

public class No338_Connect_Same_Level_Nodes {

	class Node {
		Node left;
		Node right;
		Node next;
		int data;
	}

	private Node root;
	@SuppressWarnings("unused")
	private int size = 0;

	public No338_Connect_Same_Level_Nodes(int[] arr) {

		Stack<Node> stack = new Stack<>();

		for (int val : arr)
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

	public void line_connect() {
		LinkedList<Node> queue = new LinkedList<No338_Connect_Same_Level_Nodes.Node>();

		queue.addLast(root);

		queue.add(null);

		while (!queue.isEmpty()) {

			Node temp = queue.pop();

			if (temp != null) {
				temp.right = queue.peek();

				if (temp.left != null) {
					queue.addLast(temp.left);
				}

				if (temp.right != null) {
					queue.addLast(temp.right);
				}
			}

			if (queue.isEmpty()) {
				queue.addLast(null);
			}

		}

	}

	public void Connect_Same_Level() {

		HashMap<Integer, Node> map = new HashMap<>();

		Connect_Same_Level(root, 0, map);
	}

	static int Max_Level = -1;

	private void Connect_Same_Level(Node node, int level, HashMap<Integer, Node> map) {
		if (node == null) {
			return;
		}

		if (map.containsKey(level)) {

			Node temp = map.get(level);
			temp.next = node;
			map.put(level, node);

		} else {
			map.put(level, node);
		}

		Max_Level = Math.max(level, Max_Level);

		Connect_Same_Level(node.left, level + 1, map);
		Connect_Same_Level(node.right, level + 1, map);

	}

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		No338_Connect_Same_Level_Nodes bt = new No338_Connect_Same_Level_Nodes(arr);

		bt.display();

		bt.Connect_Same_Level();

	}
}
