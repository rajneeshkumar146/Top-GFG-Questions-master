package Linked_List;

public class No291_Multiply_LinkedList {

	class Node {
		Node next;
		int data;
	}

	static Node head;

	static int size = 0;

	public int multiply(No291_Multiply_LinkedList list1, No291_Multiply_LinkedList list2) {

		Node n1 = list1.head;
		String str1 = new String();

		while (n1 != null) {

			str1 += n1.data;
			n1 = n1.next;
		}

		Node n2 = list2.head;
		String str2 = new String();

		while (n1 != null) {

			str2 += n2.data;
			n2 = n2.next;
		}

		return (Integer.parseInt(str1) * Integer.parseInt(str2));

	}

}
