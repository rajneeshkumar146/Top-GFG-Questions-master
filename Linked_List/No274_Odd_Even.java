package Linked_List;

public class No274_Odd_Even {

	class Node {
		Node next;
		int data;
	}

	static int size;
	static Node head;

	public void func() {
		int even_ctr = 0;

		Node evenPlace = head;

		Node node = head;

		while (node != null && evenPlace != null) {
			if (node.data % 2 == 0) {

				int temp = evenPlace.data;
				evenPlace.data = node.data;
				node.data = temp;
				evenPlace = evenPlace.next;
				even_ctr++;

			} else {
				node = node.next;
			}

		}

	}

//make two linkedlist odd and even add data acc and then join them atlast

}
