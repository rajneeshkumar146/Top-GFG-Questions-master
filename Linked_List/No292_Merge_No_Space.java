package Linked_List;

public class No292_Merge_No_Space {

	class Node {
		Node next;
		int data;
	}

	static Node head;

	static int size = 0;

	public static Node merge(Node h1, Node h2) {

		if (h1 == null || h2 == null) {
			return null;
		}

		if (h1.data < h2.data) {
			h1.next = merge(h1.next, h2);
			return h1;
		} else {
			h2.next = merge(h1, h2.next);
			return h2;
		}

	}

}
