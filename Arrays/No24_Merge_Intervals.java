package Arrays;

import java.util.Stack;

//https://www.geeksforgeeks.org/merging-intervals/

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class No24_Merge_Intervals {

	public static void main(String[] args) {

		Interval arr[] = new Interval[4];
		arr[0] = new Interval(1, 2);
		arr[3] = new Interval(6, 8);
		arr[1] = new Interval(3, 4);
		arr[2] = new Interval(4, 7);

		func(arr);
	}

	public static void func(Interval[] arr) {

		Stack<Interval> stack = new Stack<Interval>();

		stack.add((arr[0]));

		int x = 0;

		while (x < arr.length) {

			if ((stack.peek()).end > arr[x].start) {

				if ((stack.peek()).end > arr[x].end) {
					x++;
				} else {

					int start = (stack.pop()).start;

					Interval temp = new Interval(start, arr[x].end);

					stack.add(temp);
					x++;
					return;
				}
			}

			if ((stack.peek()).end < arr[x].start) {

				stack.add(arr[x]);
				x++;
				return;

			}

		}
		Interval result[] = new Interval[stack.size()];

		Stack<Interval> rev = new Stack<Interval>();

		while (stack.size() > 0) {

			rev.add(stack.pop());

		}

		int i = 0;

		while (rev.size() > 0) {

			result[i] = rev.pop();
			i++;
		}

		for (Interval z : rev) {
			System.out.println(" { " + z.start + " , " + z.end + " }  , ");
		}

	}

}
