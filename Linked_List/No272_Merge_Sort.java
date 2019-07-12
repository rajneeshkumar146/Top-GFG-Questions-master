package Linked_List;

import Linked_List.No282_Arbitrary_Pointer_to_Next_Higher.Node;

public class No272_Merge_Sort {

	class Node {
		Node next;
		int data;
	}

	static Node head;
	static Node tail;

	static int size;

	public static No272_Merge_Sort mergeSort(No272_Merge_Sort list) {

		No272_Merge_Sort l1 = new No272_Merge_Sort();

		No272_Merge_Sort l2 = new No272_Merge_Sort();

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

		No272_Merge_Sort list1 = mergeSort(l1);
		No272_Merge_Sort list2 = mergeSort(l2);

		return Merge(list1, list2);

	}

	private static No272_Merge_Sort Merge(No272_Merge_Sort list1, No272_Merge_Sort list2) {
		No272_Merge_Sort list = new No272_Merge_Sort();

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
		if (this.size == 0) {
			Node node = new Node();
			node.data = data;
			this.head = node;
			this.tail = node;

		} else {

			Node node = new Node();
			node.data = data;
			this.tail.next = node;
			tail = node;

		}

	}

	private Node getNodeAt(int x) {
		Node node = head;
		for (int i = 0; i < x; x++) {
			node = node.next;
		}
		return node;
	}

}
