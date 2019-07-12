package Linked_List;

import java.util.HashSet;

public class No271_Remove_Duplicate_Unsorted {

	class Node {
		Node next;
		int data;
	}

	Node Head;
	int size;

	public void func() {

		HashSet<Integer> visited = new HashSet<Integer>();
		Node node = Head;
		while (node != null) {

			if (visited.contains(node.data)) {
				remove(node);
			} else {
				visited.add(node.data);
				node = node.next;

			}

		}
	}

	private void remove(Node node) {

		Node temp = node.next;

		node.data = temp.data;
		node.next = temp.next;

		temp = null;

	}

}
