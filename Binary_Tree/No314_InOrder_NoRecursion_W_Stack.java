package Binary_Tree;

import java.util.Stack;

public class No314_InOrder_NoRecursion_W_Stack {

	class Node {
		int data;
		Node left;
		Node right;
	}

	static Node root;

	public static void func() {

		Stack<Node> stack = new Stack<No314_InOrder_NoRecursion_W_Stack.Node>();

		Node curr = root;

		while (stack.size() > 0 || curr != null) {

			while (curr != null) {
				stack.push(curr);
				curr = curr.left;

			}

			Node node = stack.pop();

			System.out.println(node.data + " ");

			curr = curr.right;
		}

	}

}
