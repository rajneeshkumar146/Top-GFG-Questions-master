package Linked_List;

import java.util.HashMap;
import java.util.HashSet;

public class No270_Intersection {
	class Node {
		Node next;
		int data;
	}

	Node Head;
	Node Head2;
	int size;

	static int ans = 0;

	// Method-1
	public void Intersection() {

		Intersection(Head, Head2);

	}

	private void Intersection(Node head, Node head2) {

		if (head != null && head2 != null) {
			Intersection(head.next, head2.next);
		} else if (head != null) {
			Intersection(head, head2.next);
		} else {
			Intersection(head.next, head2);
		}

		if (head.data != head2.data) {
			ans = head.next.data;
		}
	}

	// Method-2
	public void Intersection_visted() {
		HashSet<Integer> visited = new HashSet<Integer>();

		visited.add(Head.data);
		visited.add(Head2.data);

		Node f = Head.next;
		Node g = Head2.next;

		while (f != null) {
			if (!visited.contains(f.data)) {
				visited.add(f.data);
				f = f.next;
			} else {
				System.out.println(f.data);
				break;
			}
		}

		while (g != null) {
			if (!visited.contains(f.data)) {
				visited.add(g.data);
				g = g.next;
			} else {
				System.out.println(f.data);
				break;
			}
		}

	}

	// Method-3
	// Gives all the nodes in the intersection
	public static Node findIntersection(Node n1, Node n2) {
		HashMap<Integer, Node> map = new HashMap<>();
		HashSet<Integer> st = new HashSet<>();
		while (n1 != null) {
			st.add(n1.data);
			n1 = n1.next;
		}
		while (n2 != null) {
			if (st.contains(n2.data)) {
				map.put(n2.data, n2);
			}
			n2 = n2.next;

		}
		Node head = null;
		Node prev = null;
		for (int val : map.keySet()) {
			Node cur = map.get(val);
			if (head == null) {
				head = cur;
				prev = cur;
				cur.next = null;
			} else {
				cur.next = null;
				prev.next = cur;
				prev = cur;

			}
		}
		return insertionSortList(head);
	}

	static Node result;

	public static Node insertionSortList(Node head) {
		result = null;
		Node cur = head;

		while (cur != null) {
			Node nt = cur.next;
			insert(cur);
			cur = nt;
		}
		return result;
	}

	public static void insert(Node add) {
		if (result == null || result.data >= add.data) {
			add.next = result;
			result = add;
		} else {
			Node cur = result;
			while (cur.next != null && cur.next.data < add.data) {
				cur = cur.next;
			}
			add.next = cur.next;
			cur.next = add;
		}

	}

}