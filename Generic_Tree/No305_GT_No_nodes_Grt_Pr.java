package Generic_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class No305_GT_No_nodes_Grt_Pr {

	class Node {

		int data;

		ArrayList<Node> children = new ArrayList<>();

	}

	Node root;
	int size = 0;

	public No305_GT_No_nodes_Grt_Pr(int[] arr) {

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
			str = str + child.data + " , ";
		}

		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}

	}

	public void function() {

		function(root);
		System.out.println(ctr);
	}

	int ctr = 0;

	private void function(Node node) {

		for (Node child : node.children) {

			if (child.children.size() >= node.children.size()) {
				ctr++;
			}

			function(child);

		}

	}

	public static void main(String[] args) {

		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 140,
				-1, -1, -1 };

		No305_GT_No_nodes_Grt_Pr gt = new No305_GT_No_nodes_Grt_Pr(arr);

		gt.function();

	}

}
