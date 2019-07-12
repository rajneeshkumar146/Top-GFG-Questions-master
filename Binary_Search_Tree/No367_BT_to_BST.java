package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Collections;

public class No367_BT_to_BST {

	class Node {
		int data;
		Node left;
		Node right;
	}

	Node root;

	public void BT_to_BST() {

		if (root == null) {
			return;
		}

		ArrayList<Integer> arr = BT_to_Arr(root, new ArrayList<Integer>());

		Collections.sort(arr);

		arr_to_BST(root, arr, 0, arr.size());

	}

	private void arr_to_BST(Node node, ArrayList<Integer> arr, int start, int end) {

		if (node == null) {
			return;
		}

		if (node != null) {
			node.data = arr.get((start + end) / 2);
		}

		if (node.left != null) {

			arr_to_BST(node.left, arr, start, ((start + end) / 2) - 1);
		}

		if (node.left != null) {

			arr_to_BST(node.left, arr, ((start + end) / 2) + 1, end);
		}
	}

	private ArrayList<Integer> BT_to_Arr(Node node, ArrayList<Integer> list) {

		if (node == null) {
			ArrayList<Integer> bres = new ArrayList<>();
			return bres;
		}

		BT_to_Arr(node.left, list);
		list.add(node.data);
		BT_to_Arr(node.right, list);

		return list;

	}

	public static void main(String[] args) {

		No367_BT_to_BST bt = new No367_BT_to_BST();

		bt.BT_to_BST();

	}

}
