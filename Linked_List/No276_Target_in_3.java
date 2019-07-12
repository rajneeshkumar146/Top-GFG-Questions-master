package Linked_List;

public class No276_Target_in_3 {

	class Node {
		Node next;
		int data;
	}

	static int size = 0;
	static Node Head;
	static Node tail;

	public static boolean Target(No276_Target_in_3 list, No276_Target_in_3 list2, No276_Target_in_3 list3, int tar) {

		Node a = list.Head;

		// Sort B :- Ascending order or Merge Sort
		// Sort C :- Desending Order or Merge Sort

		while (a != null) {
			Node b = list2.Head;
			Node c = list3.Head;

			while (b != null && c != null) {
				int sum = a.data + b.data + c.data;

				if (tar == sum) {
					System.out.println("Target found :- " + a.data + " " + b.data + " " + c.data);
					return true;
				}

				else if (sum < tar) {
					b = b.next;
				} else {
					c = c.next;
				}
			}
			a = a.next;
		}
		return false;

	}

}
