import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int col = 0; col < 100; col++) {
				Stack<Integer> stack = new Stack<>();
				for (int row = 0; row < 100; row++) {
					if (arr[row][col] == 1) {
						if (stack.isEmpty()) {
							stack.push(1);
						} else {
							if (stack.peek() == 1) {
								stack.push(stack.pop());
							}
						}
					} else if (arr[row][col] == 2) {
						if (!stack.isEmpty() && stack.peek() == 1) {
							stack.pop();
							cnt++;
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}