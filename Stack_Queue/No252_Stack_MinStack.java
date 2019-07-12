package Stack_Queue;

import java.util.Stack;

//https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/

public class No252_Stack_MinStack {

	int[] arr;

	int tos = -1;

	int min_add = 0;

	public No252_Stack_MinStack(int cap) {

		arr = new int[cap];

	}

	public void push(int val) {

		if (tos == arr.length - 1) {
			System.out.println("Stack Overflow");
			return;
		}

		if (tos > 0) {

			if (this.peek() > val) {
				min_add = tos + 1;
			} else {
				min_add = tos;
			}
		}

		tos++;
		arr[tos] = val;

	}

	public int peek() {
		return arr[tos];
	}

	public int pop() {

		if (tos == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}

		int data = arr[tos];

		if (data == arr[min_add]) {

			int min = arr[tos - 1];

			for (int i = tos - 2; i >= 0; i--) {

				if (min > arr[i]) {
					min = arr[i];
					min_add = i;
				}

			}
		}

		tos--;

		return data;

	}

	public boolean isEmpty() {
		if (tos == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {

		if (tos == arr.length - 1) {

			return true;

		}

		else {
			return false;

		}

	}

	public void displayStack() {
		for (int i = tos; i > -1; i--) {

			System.out.println(arr[i] + " ");

		}

	}

	public int stackMin() {

		if (tos == -1) {
			return -1;
		} else {
			return arr[min_add];
		}

	}

	public static void main(String[] args) {
		No252_Stack_MinStack midstack = new No252_Stack_MinStack(10);

		midstack.push(18);
		midstack.push(19);
		midstack.push(29);
		midstack.push(15);
		midstack.push(16);

		midstack.displayStack();

		System.out.println();

		System.out.println(midstack.stackMin());

		midstack.pop();

		midstack.pop();

		midstack.pop();

		System.out.println();

		midstack.displayStack();

		System.out.println();

		System.out.println(midstack.stackMin());
	}

}
