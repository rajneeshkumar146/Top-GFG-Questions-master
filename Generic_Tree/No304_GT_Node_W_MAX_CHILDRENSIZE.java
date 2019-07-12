package Generic_Tree;

import java.util.ArrayList;
import java.util.Stack;

// https://www.geeksforgeeks.org/node-maximum-sum-immediate-children-n-ary-tree/

public class No304_GT_Node_W_MAX_CHILDRENSIZE {

	class Node {

		int data;

		ArrayList<Node> children = new ArrayList<>();

	}

	Node root;
	int size = 0;

	public No304_GT_Node_W_MAX_CHILDRENSIZE(int[] arr) {

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

	public void FindMaxSubTree() {

		int max = Integer.MIN_VALUE;
		for (Node temp : root.children) {
			max = Math.max(max, MaxSubTreeFinder(temp));
		}

		System.out.println(max);
	}

	public int MaxSubTreeFinder(Node node) {
		if (node.children.size() == 0)
			return node.data;

		int mymax = 0;

		for (Node temp : node.children) {
			mymax += MaxSubTreeFinder(temp);
		}

		return mymax + node.data;

	}

	public static void main(String[] args) {

		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 140,
				-1, -1, -1 };

		No304_GT_Node_W_MAX_CHILDRENSIZE gt = new No304_GT_Node_W_MAX_CHILDRENSIZE(arr);

		gt.display();

		System.out.println();

		gt.FindMaxSubTree();

	}
}
