package Linked_List;

public class No283_Fold_LinkedList {

	class Node {
		Node next;
		int data;
	}

	static Node head;

	static int size;

	public static void fold() {

		helper(head, head, 0);

		// find tail if needed

	}

	private static void helper(Node right, Node left, int ctr) {
		if (right == null) {
			return;
		}

		helper(right.next, left, ctr + 1);

		if (ctr >= size / 2) {

			Node recover = left.next;

			left.next = right;

			right.next = recover;

			left = recover;

		}
	}
}
