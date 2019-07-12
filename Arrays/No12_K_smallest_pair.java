package Arrays;

import java.util.Map;
import java.util.TreeMap;

//https://www.geeksforgeeks.org/find-k-pairs-smallest-sums-two-arrays/

class Node {
	int f;
	int s;
}

public class No12_K_smallest_pair {

	public static void main(String[] args) {

		int[] farr = { 1, 7, 11 };

		int[] sarr = { 2, 4, 6 };

		int n = 3;
		fucn(farr, sarr, n);
	}

	private static void fucn(int[] farr, int[] sarr, int n) {

		TreeMap<Integer, Node> map = new TreeMap();

		for (int i = 0; i < farr.length; i++) {

			for (int j = 0; j < sarr.length; j++) {

				Node node = new Node();

				node.f = farr[i];

				node.s = sarr[j];

				map.put((farr[i] + sarr[j]), node);

			}

		}

		int i = 1;
		for (Map.Entry<Integer, Node> data : map.entrySet()) {

			if (i <= n) {

				System.out.println(data.getKey() + " --> " + data.getValue().f + " " + data.getValue().s);

				i++;
			}
		}

	}

}
