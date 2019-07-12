package Linked_List;

public class No269_Detect_Remove_Loop {
	class Node {
		Node next;
		int data;
	}

	Node Head;
	int size;

	public void D_R_LOOP() {

		Node slow = Head;
		Node fast = Head;

		while (slow != null && fast != null && fast.next.next != null) {

			slow = slow.next;

			fast = fast.next.next;

			if (slow == fast) {
				removeLoop(slow, Head);

				System.out.println("LOOP D AND F");
			}

		}

	}

	void removeLoop(Node loop, Node head) {
		Node ptr1 = loop;
		Node ptr2 = loop;

		// Count the number of nodes in loop
		int k = 1, i;
		while (ptr1.next != ptr2) {
			ptr1 = ptr1.next;
			k++;
		}

		// Fix one pointer to head
		ptr1 = head;

		// And the other pointer to k nodes after head
		ptr2 = head;
		for (i = 0; i < k; i++) {
			ptr2 = ptr2.next;
		}

		/*
		 * Move both pointers at the same pace, they will meet at loop starting node
		 */
		while (ptr2 != ptr1) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		// Get pointer to the last node
		ptr2 = ptr2.next;
		while (ptr2.next != ptr1) {
			ptr2 = ptr2.next;
		}

		/*
		 * Set the next node of the loop ending node to fix the loop
		 */
		ptr2.next = null;
	}

	// MY_METHOD :- Use Hashset to see all nodes traveled and and when contains ==
	// true
	// Loop detected
}
