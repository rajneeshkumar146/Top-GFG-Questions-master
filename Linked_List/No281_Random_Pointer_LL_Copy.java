package Linked_List;

public class No281_Random_Pointer_LL_Copy {

	class Node {
		Node next;
		Node random;
		int data;
	}

	static int size = 0;
	static Node head;
	static Node tail;

	public No281_Random_Pointer_LL_Copy cloneIT() {

		Node curr = head;

		while (curr != null) {

			Node temp = new Node();
			temp.data = curr.data;

			temp.next = curr.next;
			curr.next = temp;

			curr = curr.next.next;

		}

		curr = head;

		while (curr != null) {

			if (curr.next != null)
				curr.next.random = (curr.random != null) ? curr.random.next : curr.random;

			curr = (curr.next != null) ? curr.next.next : curr.next;

		}

		curr = head;
		Node copy = head.next;

		No281_Random_Pointer_LL_Copy list = new No281_Random_Pointer_LL_Copy();

		list.head = copy;

		while (curr != null && copy != null) {

			curr.next = (curr.next != null) ? curr.next.next : curr.next;

			copy.next = (copy.next != null) ? copy.next.next : copy.next;
			
			curr = curr.next;
			copy = copy.next;

		}

		return list;

	}

}
