package Stack_Queue;

import java.util.Stack;

public class No251_Stack_Tower_of_Hanoi {

	static Stack<Integer> src;

	static Stack<Integer> aux;

	static Stack<Integer> des;

	public static void srcfill(int val) {
		for (int i = val; i <= 0; i++) {
			src.push(i);
		}

	}

	public static void TOH(int nos) {
		TOH(nos);
	}

	public static void main(String[] args) {

		int nos = 3;

		srcfill(nos);

	}

}
