package Generic_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class No303_GT_Just_Larger {

	class Node {
		int data;

		ArrayList<Node> children = new ArrayList<>();
	}

	Node root;
	int size = 0;

	public No303_GT_Just_Larger(int[] arr) {
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

	public int justLarger(int val) {
		justLarger(root, val);

		return min;
	}

	int min = Integer.MAX_VALUE;

	public void justLarger(Node node, int val) {
		if (node.data > val) {

			min = Math.min(min, node.data);

		}

		for (Node child : node.children) {
			justLarger(child, val);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 140,
				-1, -1, -1 };

		No303_GT_Just_Larger gt = new No303_GT_Just_Larger(arr);

		gt.display();

		System.out.println();

		System.out.println(gt.justLarger(30));

	}

}
