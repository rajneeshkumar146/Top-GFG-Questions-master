package Linked_List;

public class No275_Sum_The_LL {

	class Node {
		Node next;
		int data;
	}

	static int size = 0;
	static Node Head;
	static Node tail;

	public Node add_them(No275_Sum_The_LL list, No275_Sum_The_LL list2) {

		Node temp1 = list.Head;
		Node temp2 = list2.Head;

		temp1 = reverseList(temp1);
		temp2 = reverseList(temp2);

		Node head = null;
		Node prev = null;
		int sum = 0;
		int carry = 0;

		while (temp1 != null || temp2 != null) {

			int ld = 0;
			int rd = 0;

			if (temp1 != null) {
				ld = temp1.data;
			}

			if (temp2 != null) {
				rd = temp2.data;
			}

			sum = ld + rd + carry;

			carry = sum / 10;

			sum = sum % 10;

			if (head == null) {
				Node node = new Node();
				node.data = sum;

				head = node;
				tail = node;
			} else {

				Node node = new Node();
				node.data = sum;
				tail.next = node;
				tail = node;

			}
			if (temp1 != null) {
				temp1 = temp1.next;
			}

			if (temp2 != null) {
				temp2 = temp2.next;
			}

			if (carry != 0) {
				Node node = new Node();
				node.data = carry;
				prev.next = node;
			}

		}

		head = reverseList(head);
		return head;

	}

	private static Node reverseList(Node node) {

		Node prev = null;
		Node curr = node;

		while (curr != null) {
			Node mynext = curr.next;

			curr.next = prev;
			prev = curr;
			curr = curr.next;
		}

		return prev;
	}

	public static void main(String[] args) {
		String str = "563";

		String str2 = "842";

		String ans = String.valueOf(Integer.parseInt(str) + Integer.parseInt(str2));

		System.out.println(ans);

	}
}
