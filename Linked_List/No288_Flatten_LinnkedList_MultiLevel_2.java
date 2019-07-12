package Linked_List;

public class No288_Flatten_LinnkedList_MultiLevel_2 {

//	
//	1 - 2 - 3 - 4
//    |
//    7 -  8 - 10 - 12
//    |    |    |
//    9    16   11
//    |    |
//    14   17 - 18 - 19 - 20
//    |                    |
//    15 - 23             21
//         |
//         24

	class Node {
		Node next;
		Node down;
		int data;
	}

	static Node head;
	static int size;

	public static void func() {

		Node curr = head;

		while (curr.next != null) {
			curr = curr.next;
		}

		Node tail = curr;

		curr = head;

		Node temp = null;

		while (curr.next != null) {

			if (curr.down != null) {

				tail.next = curr.down;

				temp = curr.down;

				while (temp.next != null) {
					temp = temp.next;
				}

				tail = temp;

			}
			curr = curr.next;

		}

	}

	
	//depth first
	static Node last = null;

	public static Node flattenList(Node node) {
		if (node == null)
			return null;

		// To keep track of last visited node
		// (NOTE: This is static)
		last = node;

		// Store next pointer
		Node next = node.next;

		// If down list exists, process it first
		// Add down list as next of current node
		if (node.down != null)
			node.next = flattenList(node.down);

		// If next exists, add it after the next
		// of last added node
		if (next != null)
			last.next = flattenList(next);

		return node;
	}

}
