package Linked_List;

public class No268_Nth_Node_From_End {

	class Node {
		Node next;
		int data;
	}

	Node Head;
	int size;

	public void NthNode(int n) {

		if (n == 0) {
			System.out.println(Head);
			return;
		} else if (n > size) {
			System.out.println("N out of Range");
			return;
		} else {
			Node fast = Head;
			for (int i = 0; i < n; i++) {
				fast = fast.next;
			}

			Node slow = Head;

			while (fast.next != null) {
				slow = slow.next;
				fast = fast.next;
			}

			System.out.println(slow.data);
		}
	}

}
