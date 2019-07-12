package Binary_Tree;

import java.util.ArrayList;
import java.util.Stack;

import Binary_Tree.No350_K_far_Nodes.Node;

public class No351_Distance_BTW_2_Nodes {

	class Node {
		Node left;
		Node right;
		int data;

	}

	static Node root;
	static int size = 0;

	public No351_Distance_BTW_2_Nodes(int[] arr) {
		Stack<Node> stack = new Stack<No351_Distance_BTW_2_Nodes.Node>();

		for (int val : arr) {

			if (val == -1) {
				stack.pop();
			} else {
				Node node = new Node();
				node.data = val;

				size++;

				if (stack.size() == 0) {
					root = node;
				}

				if (stack.size() > 0) {
					if (stack.peek().left == null) {
						stack.peek().left = node;

					} else {
						stack.peek().right = node;
					}
				}

				stack.push(node);
			}

		}
	}

	public void display() {

		display(root);

	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = new String();

		str += node.left != null ? node.left.data : ".";

		str += "<- " + node.data + " -> ";

		str += node.right != null ? node.right.data : ".";

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public ArrayList<Integer> Nodetorootpath(int data) {
		return NodeToRootPath(root, data);
	}

	private ArrayList<Integer> NodeToRootPath(Node node, int data) {

		if (node == null) {
			ArrayList<Integer> bres = new ArrayList<Integer>();
			return bres;
		}

		if (node.data == data) {
			ArrayList<Integer> ans = new ArrayList<Integer>();
			ans.add(node.data);
			return ans;
		}

		ArrayList<Integer> result = NodeToRootPath(node.left, data);

		if (result.size() > 0) {
			result.add(node.data);
			return result;
		}

		result = NodeToRootPath(node.right, data);

		if (result.size() > 0) {
			result.add(node.data);
			return result;
		}

		return result;
	}

	public int distanceBtWNodes(int i, int j) {
		ArrayList<Integer> listi = Nodetorootpath(i);
		ArrayList<Integer> listj = Nodetorootpath(j);

		int sizei = listi.size() - 1;
		int sizej = listj.size() - 1;

		int lca = 0;
		while (sizei >= 0 && sizej >= 0) {

			if (listi.get(sizei) != listj.get(sizej)) {
				lca = listi.get(sizei + 1);
				break;
			}

			sizei--;
			sizej--;
		}

		ArrayList<Integer> lcaList = Nodetorootpath(lca);

		return ((listi.size() + listj.size()) - 2 * lcaList.size());

	}

	public static void main(String[] args) {

		// int[] arr = { 50, 25, 12, -1, 73, -1, -1, 75, 62, -1, 87, -1, -1, -1 };

		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };

		No351_Distance_BTW_2_Nodes bt = new No351_Distance_BTW_2_Nodes(arr);

		bt.display();

		System.out.println();

		System.out.println(bt.distanceBtWNodes(25, 75));

		System.out.println();

	}

}
