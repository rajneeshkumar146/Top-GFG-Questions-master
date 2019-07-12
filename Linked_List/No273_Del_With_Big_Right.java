package Linked_List;

public class No273_Del_With_Big_Right {
	private class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public void del_Big_Right() {
		reversepointerrecursive();

		Node curr = head;
		Node max = head;
		Node temp;
		while (curr != null && curr.next != null) {
			if (curr.next.data > max.data) {
				temp = curr.next;
				curr.next = temp.next;
				temp = null;
			} else {
				curr = curr.next;
				max = max.next;
			}
		}

		reversepointerrecursive();

	}

	public void reversepointerrecursive() {

		reversepointerrecursivehelper(head);

		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	private void reversepointerrecursivehelper(Node node) {

		if (node.next == null) {
			return;
		}
		reversepointerrecursivehelper(node.next);

		node.next.next = node;
	}

}
