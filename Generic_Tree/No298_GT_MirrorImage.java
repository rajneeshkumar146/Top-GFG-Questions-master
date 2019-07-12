package Generic_Tree;

import java.util.ArrayList;
import java.util.Stack;

public class No298_GT_MirrorImage {

	class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

	}

	Node root;
	int size = 0;

	public No298_GT_MirrorImage(int[] arr) {

		Stack<Node> stack = new Stack();

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

			}

			else {
				stack.pop();
			}

		}

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		String str = node.data + " :-> ";

		for (Node child : node.children) {
			str = str + node.data + " , ";
		}

		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}

	}

	public void isMirrorImage(No298_GT_MirrorImage gt2) {
		if (isMirrorImage(this.root, gt2.root)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

	private boolean isMirrorImage(Node gt, Node gt2) {
		if (gt.children.size() != gt2.children.size()) {
			return false;
		}

		for (int i = 0; gt.children.size() - 1 > 0; i++) {

			Node n = gt.children.get(i);

			Node o = gt2.children.get(gt2.children.size() - i);

			if (!isMirrorImage(n, o)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 140,
				-1, -1, -1 };

		int[] arr2 = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 140,
				-1, -1, -1 };
		No298_GT_MirrorImage gt = new No298_GT_MirrorImage(arr);

		No298_GT_MirrorImage gt2 = new No298_GT_MirrorImage(arr2);

		gt.isMirrorImage(gt2);

	}
}
