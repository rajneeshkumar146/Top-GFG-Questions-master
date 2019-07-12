package Generic_Tree;

import java.util.*;

public class No300_GT_Just_Smaller {

	class Node {
		int data;

		ArrayList<Node> children = new ArrayList<>();
	}

	Node root;
	int size = 0;

	public No300_GT_Just_Smaller(int[] arr) {
		Stack<Node> stack = new Stack<>();

		for (int val : arr) {
			if (val != -1) {
				Node temp = new Node();

				temp.data = val;

				size++;

				if (stack.size() == 0) {
					root = temp;
				} else {
					stack.peek().children.add(temp);

				}

				stack.push(temp);
			} else {
				stack.pop();
			}
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		String str = node.data + " : -  ";

		for (Node child : node.children) {
			str = str + node.data + " , ";
		}

		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}

	}

	public int justSmaller(int val) {
		justSmaller(root, val);

		return max;
	}

	int max = 0;

	public void justSmaller(Node node, int val) {
		if (node.data < val) {

			if (max < node.data) {
				max = node.data;
			}

		}

		for (Node child : node.children) {
			justSmaller(child, val);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 140,
				-1, -1, -1 };

		No300_GT_Just_Smaller gt = new No300_GT_Just_Smaller(arr);

		gt.display();

		System.out.println();

		System.out.println(gt.justSmaller(110));

	}
}
