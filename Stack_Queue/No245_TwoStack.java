package Stack_Queue;

import java.util.Scanner;

// https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/

public class No245_TwoStack {

	static int[] arr = new int[500];

	static int esize = 0;
	static int e = 0;
	static int osize = 0;
	static int o = 1;

	public static void push1(int val) {

		if (esize == 0) {
			arr[e] = val;
			e += 2;
			esize++;
		} else {

			if (e + 2 > arr.length) {
				System.out.println("STACK OVERFLOW");
			}
			arr[e] = val;
			e += 2;
			esize++;
		}

	}

	public static void pop1() {

		System.out.println(arr[e - 2]);
		arr[e] = 0;
		e -= 2;
		esize--;

	}

	public static int peek1() {
		if (e - 2 < 0) {
			return -1;
		} else {
			return arr[e - 2];
		}
	}

	public static void push2(int val) {

		if (osize == 0) {
			arr[o] = val;
			o += 2;
			osize++;
		} else {

			if (o + 2 > arr.length) {
				System.out.println("STACK OVERFLOW");
			}
			arr[o] = val;
			o += 2;
			osize++;
		}

	}

	public static void pop2() {

		System.out.println(arr[o - 2]);
		arr[o] = 0;
		o -= 2;
		osize--;

	}

	public static int peek2() {

		if (o - 2 < 0) {
			return -1;
		} else {

			return arr[o - 2];

		}

	}

	public static void main(String[] args) {

		push1(10);
		push2(100);
		push1(20);
		push2(200);
		push1(30);
		push2(300);
		push1(40);
		push2(400);

		System.out.println(peek1() + "  " + peek2());

		System.out.println();

		pop1();
		pop2();
		pop1();
		pop2();
		pop1();
		pop2();
		pop1();
		pop2();

	}
}
