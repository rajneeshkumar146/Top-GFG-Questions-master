package Linked_List;

import Linked_List.No272_Merge_Sort.Node;
import Sorting.merge;

public class No282_Arbitrary_Pointer_to_Next_Higher {

	class Node {
		Node next;
		Node bigger;
		int data;
	}

	static Node head;
	static Node tail;

	static int size = 0;

	public static void func(No282_Arbitrary_Pointer_to_Next_Higher list) {

		Node node = list.head;

		while (node != null) {

			node.bigger = node.next;

			node = node.next;
		}

		list = mergeSort(list);

	}

	public static No282_Arbitrary_Pointer_to_Next_Higher mergeSort(No282_Arbitrary_Pointer_to_Next_Higher list) {

		Node n1 = list.head;
		Node n2 = list.GetNodeAt(size / 2);

		No282_Arbitrary_Pointer_to_Next_Higher l1 = new No282_Arbitrary_Pointer_to_Next_Higher();

		while (n1 != n2) {
			l1.addLast(n1.data);
			n1 = n1.bigger;
		}

		No282_Arbitrary_Pointer_to_Next_Higher l2 = new No282_Arbitrary_Pointer_to_Next_Higher();
		while (n2 != null) {
			l2.addLast(n2.data);
			n2 = n2.bigger;
		}

		No282_Arbitrary_Pointer_to_Next_Higher list1 = mergeSort(l1);

		No282_Arbitrary_Pointer_to_Next_Higher list2 = mergeSort(l2);

		return merge(list1, list2);

	}

	private static No282_Arbitrary_Pointer_to_Next_Higher merge(No282_Arbitrary_Pointer_to_Next_Higher list1,
			No282_Arbitrary_Pointer_to_Next_Higher list2) {

		No282_Arbitrary_Pointer_to_Next_Higher list = new No282_Arbitrary_Pointer_to_Next_Higher();

		Node temp = list1.head;
		Node temp2 = list2.head;

		while (temp != null && temp2 != null) {

			if (temp.data < temp2.data) {

				list.addLast(temp2.data);

				temp = temp.bigger;

			} else {
				list.addLast(temp2.data);

				temp2 = temp2.bigger;
			}

			while (temp != null) {
				list.addLast(temp.data);

				temp = temp.bigger;
			}

			while (temp2 != null) {
				list.addLast(temp2.data);

				temp2 = temp2.bigger;
			}

		}

		return list;
	}

	private void addLast(int data) {

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

	private Node GetNodeAt(int n) {
		Node node = head;

		for (int i = 0; i < n; i++) {

			node = node.next;
		}
		return node;
	}

}
