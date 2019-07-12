package Linked_List;

import java.util.Scanner;

public class No278_Sort_0_1_2 {

	static int size = 0;
	static Node tail;

	public static void sort012(Node head) {

		int[] count = { 0, 0, 0 };

		Node temp = head;

		while (temp != null) {
			count[temp.data] += 1;

			temp = temp.next;
		}

		int i = 0;
		temp = head;

		while (temp != null) {

			if (count[i] == 0) {
				i++;
			} else {
				temp.data = i;
				--count[i];
				temp = temp.next;

			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		head = insert(head, a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			head = insert(head, a);
		}

		sort012(head);
		display(head);

	}

	// Class declaration for a Node of the Linked List
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	static Node head;

	static Node head2;

	static Node head3;

	/*
	 * Input Parameters: head: head of the linked list in which a new node is to be
	 * inserted. data: the data value of the node which is to be inserted.
	 * 
	 * Return Value: head of the linked list in which the node is inserted
	 */
	public static Node insert(Node head, int data) {

		if (head == null) {
			return new Node(data);
		}

		head.next = insert(head.next, data);
		return head;
	}

	/*
	 * Input Parameters: head: head of the linked list in which is to be displayed.
	 * 
	 * Return Value: null
	 */
	public static void display(Node head) {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

}