import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '(') {
					stack.push(arr[j]);
				}
				else if (arr[j] == ')') {
					if (stack.isEmpty()) {
						stack.push(arr[j]);
						break;
					}
					stack.pop();
				}
			}
			sb.append(stack.isEmpty() ? "YES" : "NO").append("\n");
			stack.clear();
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.print(sb);
	}
}