package Linked_List;

import java.util.PriorityQueue;

public class No287_Merge_K_sorted_Linked_list {

	class Node {
		Node next;
		int data;
	}

	static Node head;

	static int size = 0;

	public No287_Merge_K_sorted_Linked_list merge(Node[] arr, int k) {

		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		for (int i = 0; i < k; i++) {

			pq.add(arr[i]);

		}

		Node head = null;

		Node tail = null;

		while (!pq.isEmpty()) {

			Node temp = pq.remove();

			if (temp.next != null) {

				pq.add(temp.next);

			}
			if (head == null) {

				head = temp;
				tail = temp;

			} else {

				tail.next = temp;

				tail = temp;

			}

		}

		No287_Merge_K_sorted_Linked_list list = new No287_Merge_K_sorted_Linked_list();

		list.head = head;

		return list;

	}

	public static void main(String[] args) {
		Node[] arr = new Node[5];

		// Each Node in the array is the head of a small n sized linkedlist

		int k = 3; // NUMBER OF LLS - ARR.LENGHT()
		int n = 4; // Number of elements
	}
}
