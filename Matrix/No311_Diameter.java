package Matrix;

import java.util.ArrayList;
import java.util.Stack;

//https://www.geeksforgeeks.org/diameter-n-ary-tree/

public class No311_Diameter {

	class Node {
		int data;
		boolean locked = false;
		ArrayList<Node> children = new ArrayList<>();
	}

	Node root;
	int size = 0;

	public No311_Diameter(int[] arr) {

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

	public void height() {
		System.out.println(height(root));
	}

	public int height(Node node) {
		int myheight = 0;

		int height = 0;

		for (Node child : node.children) {

			myheight = height(child);

			height = Math.max(height, myheight);

		}
		height += 1;

		return height + 1;

	}

	public static void main(String[] args) {

		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 140,
				-1, -1, -1 };

		No311_Diameter gt = new No311_Diameter(arr);

		gt.display();

		System.out.println();

		gt.height();

	}

}
