package Stack_Queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Comparator;

//https://www.geeksforgeeks.org/implement-stack-using-priority-queue-or-heap/

public class No248_Stack_Using_PriorityQueue {

	class Pair {
		int val;
		int key;

		Pair(int val, int key) {
			this.val = val;

			this.key = key;
		}

		PriorityQueue<Pair> stack = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair p1, Pair p2) {

				return p2.key - p1.key;
			}

		});

		int stacker = 0;

		public void push(int val) {

			Pair temp = new Pair(val, stacker++);
			stack.add(temp);

		}

		public int peek() {

			Pair temp = stack.peek();

			return temp.val;

		}

		public int pop() {
			Pair temp = stack.remove();

			return temp.val;
		}

	}

}
