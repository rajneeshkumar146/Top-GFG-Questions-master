package Stack_Queue;

import java.util.Stack;

//https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/

public class No254_Stack_Longest_Length_Parenthesis {

	public static void paraLenght(String str) {
		
		int maxans = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(-1);
		
		for (int i = 0; i < str.length(); i++) {
		
			if (str.charAt(i) == '(') {
			
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}

		System.out.println(maxans);
	}

	public static void main(String[] args) {

		paraLenght("())((())");

	}

}
