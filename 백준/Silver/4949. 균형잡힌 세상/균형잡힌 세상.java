import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		String str;
		while((str = br.readLine()) != null) {
			if (str.equals(".")) break;
			char[] arr = str.replace(" ", "").toCharArray();
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] == '[' || arr[i] == '(') {
					stack.push(arr[i]);
				} else if (arr[i] == ']') {
					if (!stack.isEmpty() &&stack.peek() == '[') {
						stack.pop();
					} else {
						stack.push(arr[i]);
						break;
					}
				} else if (arr[i] == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						stack.push(arr[i]);
						break;
					}
				}
			}

			if (stack.isEmpty()) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
			stack.clear();
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.print(sb);
	}
}