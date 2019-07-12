package Linked_List;

import LinkedList.LinkedList;

public class No285_ZigZag_LinkedList {

	class Node {
		Node next;
		int data;
	}

	static int size = 0;

	static Node head;

	public void zigzag() {
		if (head == null) {
			return;
		}
		Node curr = head;
		
		int count = 0;
		
		while (curr.next != null) {
			if (count % 2 == 0) {
				// check if curr < curr.next
				if (curr.data > curr.next.data) {
					swap(curr, curr.next);
				}
			} else {
				// check if curr > curr.next
				if (curr.data < curr.next.data) {
					swap(curr, curr.next);
				}
			}
			count++;
			curr = curr.next;
		}
	}

	private void swap(Node a, Node b) {
		int t = a.data;
		a.data = b.data;
		b.data = t;
	}
}
