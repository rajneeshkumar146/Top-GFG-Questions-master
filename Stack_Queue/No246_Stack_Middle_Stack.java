package Stack_Queue;

//https://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/

public class No246_Stack_Middle_Stack {

	class Node {
		int data;
		Node up;
		Node down;
	}

	Node top;
	Node mid;
	int size = -1;

	public void push(int val) {

		Node node = new Node();
		node.data = val;

		if (size == -1) {
			mid = node;
		}

		if (top == null) {

			top = node;

		} else {

			node.down = top;
			top.up = node;
			top = node;

		}

		size++;

		if (size % 2 != 0) {
			mid = mid.up;
		}

	}

	public int peek() {
		return top.data;
	}

	public int pop() {

		int pop = top.data;

		top = top.down;
		size--;

		if (size % 2 != 0) {
			mid = mid.down;
		}

		return pop;
	}

	public void display() {

		if (this.size == 0) {
			System.out.println("UNDERFLOW");
		} else {
			display(top);
		}
	}

	public int displayMid() {

		return mid.data;

	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		System.out.println(node.data + " <- ");

		display(node.down);

	}

	public static void main(String[] args) {

		No246_Stack_Middle_Stack stack = new No246_Stack_Middle_Stack();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		stack.push(90);
		// stack.push(100);

		stack.display();

		System.out.println();

		System.out.println("MID :-" + stack.displayMid());

		System.out.println();

		System.out.println("PEEK :-" + stack.peek());

		System.out.println();

		System.out.println("POP :-" + stack.pop());

		System.out.println();

		stack.display();

		System.out.println();

		System.out.println("MID :-" + stack.displayMid());

		System.out.println();

		System.out.println("PEEK :-" + stack.peek());

		System.out.println();

		System.out.println("POP :-" + stack.pop());

		System.out.println();
	}

}
