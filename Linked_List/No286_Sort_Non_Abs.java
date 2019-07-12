package Linked_List;

public class No286_Sort_Non_Abs {

	class Node {
		Node next;
		int data;
	}

	static int size = 0;

	static Node head;

	public void sortLinkedList() {
		Node prev = head;
		Node curr = head.next;

		while (curr != null) {

			if (prev.data > curr.data) {

				prev.next = curr.next;

				curr.next = head;
				head = curr;

				curr = prev;

			} else {
				curr = prev;
			}

			prev = prev.next;

		}

	}
}