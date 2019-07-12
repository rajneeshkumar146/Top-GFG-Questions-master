package Generic_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class No299_GT_Serialize {

	class Node {

		int data;

		ArrayList<Node> children = new ArrayList<>();

	}

	Node root;
	int size = 0;

	public No299_GT_Serialize(int[] arr) {

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

			} else {
				stack.pop();
			}
		}

	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		String str = node.data + ": -  > ";

		for (Node child : node.children) {
			str = str + child.data + " , ";
		}

		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}

	}

	public void Serialize() {
		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(root);

		while (queue.size() > 0) {

			for (Node node : queue.peek().children) {

				queue.addLast(node);
			}

			System.out.print(queue.removeFirst().data + " ");
		}

	}

	public static void main(String[] Args) {

		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 140,
				-1, -1, -1 };

		No299_GT_Serialize gt = new No299_GT_Serialize(arr);

		gt.display();

		System.out.println();

		gt.Serialize();

	}

}
