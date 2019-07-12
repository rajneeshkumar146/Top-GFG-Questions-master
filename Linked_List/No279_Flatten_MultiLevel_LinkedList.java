package Linked_List;

import Linked_List.No278_Sort_0_1_2.Node;

public class No279_Flatten_MultiLevel_LinkedList {
	class Node {
		Node next;
		Node down;
		int data;
	}

	static int size = 0;
	static Node head;
	static Node tail;

	public void flatten() {

		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}

		Node tail = curr;

		Node temp = null;

		curr = head;

		while (curr.next != null) {

			if (curr.down != null) {

				tail.next = curr.down;

				temp = curr.down;

				while (temp.next != null) {
					temp = temp.next;
				}
				tail = temp;

			}

			curr = curr.next;

		}

	}

}
