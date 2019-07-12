package Linked_List;

public class No289_Difference_of_LL {

	class Node {
		Node next;
		int data;
	}

	static Node head;
	static Node tail;
	static int size = 0;

	public static No289_Difference_of_LL func(No289_Difference_of_LL list1, No289_Difference_of_LL list2) {

		Node t1 = list1.head;
		String str1 = new String();

		while (t1 != null) {
			str1 += t1.data;

			t1 = t1.next;
		}

		Node t2 = list2.head;
		String str2 = new String();

		while (t2 != null) {
			str2 += t2.data;

			t2 = t2.next;
		}

		int n1 = Integer.parseInt(str1);
		int n2 = Integer.parseInt(str2);

		String ans = new String();

		if (n1 > n2) {
			ans = String.valueOf(n1 - n2);
		} else {
			ans = String.valueOf(n2 - n1);
		}
		No289_Difference_of_LL res = new No289_Difference_of_LL();
		for (int i = 0; i < ans.length(); i++) {

			res.addLast(ans.charAt(i));

		}

		return res;

	}

	private void addLast(int data) {

		if (this.size == 0) {
			Node node = new Node();
			size++;

			node.data = data;
			this.head = node;
			this.tail = node;

		} else {

			Node node = new Node();

			size++;

			node.data = data;
			tail.next = node;

			tail = node;
		}

	}
}
