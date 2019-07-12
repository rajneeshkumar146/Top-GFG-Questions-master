package Linked_List;

public class No266_Delete_By_Reference {

	class Node {
		Node next;
		int data;
	}

	public void DeleteNode(Node node) {
		Node temp = node.next;
		node.next = temp.next;
		node.data = temp.data;

		temp = null;

	}

}
