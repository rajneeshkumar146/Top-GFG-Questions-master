package String;

//https://www.geeksforgeeks.org/generate-all-binary-strings-from-given-pattern/

public class No79_String_with_Q {

	public static void main(String[] args) {

		String str = "1?????????1";

		char[] arr = str.toCharArray();

		func(arr, 0);
	}

	public static void func(char[] str, int i) {

		if (str.length == i) {
			System.out.println(str);
			return;
		}

		if (str[i] == '?') {

			str[i] = '1';
			func(str, i + 1);

			str[i] = '0';
			func(str, i + 1);

			str[i] = '?';
		}

		else {
			func(str, i + 1);
		}

	}

}
