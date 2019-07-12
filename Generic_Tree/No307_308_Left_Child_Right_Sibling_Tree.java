package Generic_Tree;

import java.util.ArrayList;
import java.util.Stack;

//https://www.geeksforgeeks.org/left-child-right-sibling-representation-tree/
//https://www.geeksforgeeks.org/creating-tree-left-child-right-sibling-representation/

public class No307_308_Left_Child_Right_Sibling_Tree {
	class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	Node root;
	int size = 0;

	public No307_308_Left_Child_Right_Sibling_Tree(int[] arr) {

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

	public void display(Node temp) {
		String str = temp.data + " :-> ";

		for (Node child : temp.children) {
			str = str + child.data;
		}

		System.out.println(str);

		for (Node child : temp.children) {
			display(child);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
