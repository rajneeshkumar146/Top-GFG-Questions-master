package Linked_List;

public class No290_Find_Target {

	class Node {
		Node next;
		int data;
	}

	static int size = 0;
	static Node head;
	static Node tail;

	public void target(int tar) {
		Node left = head;
		boolean flag = false;
		target(head, left, tar);
	}

	static boolean right_flag = false;

	public void target(Node right, Node left, int tar) {

		if (right == null || left == null) {
			return;
		}

		if ((right.data + left.data) == tar) {

			System.out.println(right.data + " + " + left.data);

		}

		if (right_flag == false) {

			target(right.next, left, tar);

		}

		right_flag = true;
		target(right, left.next, tar);
	}

}
