package Stack_Queue;

import java.util.Stack;

public class No249_Stack_Infix_Postfix {
	public static int Pre(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '/':
		case '*':
			return 2;

		case '^':
			return 3;

		}
		return -1;
	}

	public static String infixTOpostfix(String str) {
		Stack<Character> stack = new Stack<>();
		String result = new String("");

		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);

			// If the scanned character is an operand, add it to output.
			if (Character.isLetterOrDigit(c))
				result += c;

			// If the scanned character is an '(', push it to the stack.
			else if (c == '(')
				stack.push(c);

			// If the scanned character is an ')', pop and output from the stack
			// until an '(' is encountered.
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();

				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression"; // invalid expression
				else
					stack.pop();
			} else // an operator is encountered
			{
				while (!stack.isEmpty() && Pre(c) <= Pre(stack.peek()))
					result += stack.pop();
				stack.push(c);
			}

		}

		// pop all the operators from the stack
		while (!stack.isEmpty())
			result += stack.pop();

		return result;
	}

	public static void main(String[] args) {

		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixTOpostfix(exp));

	}
}