package Stack_Queue;

import java.util.HashMap;
import java.util.Stack;

// https://www.geeksforgeeks.org/find-expression-duplicate-parenthesis-not/

public class No255_Stack_Duplicate_Parenthesis {

	class Node {

		char val;

		int idx;

		Node next;

	}

	Node Top;

	int size = 0;

	public void push(char val, int idx) {

		if (size == 0) {

			handleWhenZero(val, idx);

		}

	}

	private void handleWhenZero(char val, int idx) {
		Node node = new Node();

		node.val = val;

		node.idx = idx;

	}

	public static boolean func(String str) {

		for (int i = 1; i < str.length(); i++) {

			if (str.charAt(i) == '(') {
				/// push(str.charAt(i), i);
			}

		}

		return false;

	}

	public static void main(String[] args) {

		if (func("((a+(b))+(c+d))")) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

	}

}
