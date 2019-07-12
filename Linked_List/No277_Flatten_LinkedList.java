package Linked_List;

public class No277_Flatten_LinkedList {

	class Node {
		Node next;
		Node down;
		int data;
	}

	static int size = 0;
	static Node head;
	static Node tail;

	public void flat() {

		No277_Flatten_LinkedList ans = new No277_Flatten_LinkedList();
		Node node = head;

		while (node != null) {
			ans.addlast(node.data);

			Node temp = node.down;

			while (temp != null) {

				ans.addlast(temp.data);

				temp = temp.down;

			}

			node = node.next;

		}

	}

	public static No277_Flatten_LinkedList mergeSort(No277_Flatten_LinkedList list) {

		No277_Flatten_LinkedList l1 = new No277_Flatten_LinkedList();

		No277_Flatten_LinkedList l2 = new No277_Flatten_LinkedList();

		Node n1 = head;
		Node n2 = list.getNodeAt(list.size / 2);

		while (n1 != n2) {
			l1.addlast(n1.data);
			n1 = n1.next;
		}

		while (n2 != null) {
			l2.addlast(n2.data);
			n2 = n2.next;
		}

		No277_Flatten_LinkedList list1 = mergeSort(l1);
		No277_Flatten_LinkedList list2 = mergeSort(l2);

		No277_Flatten_LinkedList ans = Merge(list1, list2);

		return ans;

	}

	private static No277_Flatten_LinkedList Merge(No277_Flatten_LinkedList list1, No277_Flatten_LinkedList list2) {
		No277_Flatten_LinkedList list = new No277_Flatten_LinkedList();

		Node temp = list1.head;
		Node temp2 = list2.head;

		while (list1 != null && list2 != null) {

			if (temp.data < temp2.data) {
				list.addlast(temp.data);

				temp = temp.next;
			} else {
				list.addlast(temp2.data);

				temp2 = temp2.next;

			}

		}

		while (list1 != null) {
			list.addlast(temp.data);

			temp = temp.next;

		}

		while (list2 != null) {
			list.addlast(temp2.data);

			temp2 = temp2.next;

		}
		return list;
	}

	private void addlast(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		tail.next = node;

		tail = node;
	}

	private Node getNodeAt(int x) {
		Node node = head;
		for (int i = 0; i <= x; x++) {
			node = node.next;
		}
		return node;
	}

	/////////////////////////////////////////////////////////////

	public static void flatten() {

		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		Node tail = temp;
		Node downer = null;

		while (temp != tail) {

			if (temp.down != null) {

				tail.next = temp.down;

				downer = temp.down;

				tail = downer;

			}
			temp = temp.next;
		}

		// mergeSort();

	}
}
