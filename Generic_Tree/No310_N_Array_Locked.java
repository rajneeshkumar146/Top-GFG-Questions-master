package Generic_Tree;

import java.util.ArrayList;
import java.util.Stack;

//  https://www.careercup.com/question?id=10508082

public class No310_N_Array_Locked {

	class Node {
		int data;
		boolean locked = false;
		ArrayList<Node> children = new ArrayList<>();
	}

	Node root;
	int size = 0;

	public No310_N_Array_Locked(int[] arr) {

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

	public boolean isLocked(Node node) {

		return node.locked;
	}

	public void locker(Node node) {

		if (node.locked) {
			System.out.println("LOCKED");
		}

		if (parentLockCheck(node)) {
			node.locked = true;

			System.out.println("LOCKED");
		} else {
			System.out.println("Cant LOCKED");
		}

	}

	public boolean parentLockCheck(Node node) {
		return parentLockCheck(root, node);
	}

	private boolean parentLockCheck(Node parent, Node child) {

		if (!parent.locked) {
			return parent.locked;
		}

		if (parent.children.contains(child)) {
			return parent.locked;
		}

		for (Node temp : parent.children) {
			if (temp.locked) {
				boolean ans = parentLockCheck(temp, child);

				if (ans) {
					return ans;
				}
			}
		}

		return false;
	}

	public void unLocker(Node node) {

		for (Node temp : node.children) {
			if (!temp.locked) {
				node.locked = false;
				System.out.println("Un-LOCKED");

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

	public void displayLocker() {
		displayLocker(root);
	}

	private void displayLocker(Node node) {

		String str = node.data + " : -  ";

		for (Node child : node.children) {
			str = str + child.locked + " , ";
		}

		System.out.println(str);

		for (Node child : node.children) {
			displayLocker(child);
		}

	}

	public void LockUp() {
		root.locked = true;

		for (Node temp : root.children) {

			temp.locked = true;

		}

	}

	public static void main(String[] args) {

		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 140,
				-1, -1, -1 };

		No310_N_Array_Locked gt = new No310_N_Array_Locked(arr);

		gt.display();

		System.out.println();

		gt.LockUp();

		gt.displayLocker();
	}

}
