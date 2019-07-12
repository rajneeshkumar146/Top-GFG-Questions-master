package Linked_List;

public class No293_Rotate_With_K_D {

	class Node {
		Node next;
		int data;
	}

	static Node head;
	static Node tail;
	static int size = 0;

	// Simple
	public void kreverse(int k) {

		No293_Rotate_With_K_D curr = new No293_Rotate_With_K_D();

		No293_Rotate_With_K_D prev = new No293_Rotate_With_K_D();

		while (this.size != 0) {
			for (int i = 0; i < k; i++) {
				curr.addfirstnode(this.removeFirstNode());
			}

			if (prev.size == 0) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size = curr.size;

			}

			curr = new No293_Rotate_With_K_D();
		}
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}

	private Node removeFirstNode() {
		if (size == 0) {
			System.out.println("List is empty");
			return null;
		}

		if (size == 1) {
			return handleremovalofnodewhensize1();
		}

		Node rv = head;

		head = head.next;

		rv.next = null;
		size--;

		return rv;

	}

	private Node handleremovalofnodewhensize1() {

		Node rv = head;
		head = tail = null;

		size = 0;
		return rv;

	}

	public void addfirstnode(Node node) {

		if (size == 0) {
			handleaddnodewhensize0(node);
			return;
		}

		node.next = head;
		head = node;

		size++;
	}

	private void handleaddnodewhensize0(Node node) {
		head = tail = node;

		size++;

	}

	public void addnodeLast(Node node) {

		if (size == 0) {
			handleaddnodewhensize0(node);
			return;
		}

		tail.next = node;

		tail = node;

		size++;

	}

}
