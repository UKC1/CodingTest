import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int getClapCount = clapCount(test_case);
			if (getClapCount == 0) {
				sb.append(test_case);
			} else {
				for (int i = 0; i < getClapCount; i++) {
					sb.append("-");
				}
			}
			sb.append(" ");
		}
		System.out.println(sb.toString().trim());
	}

	public static int clapCount(int n) {
		int cnt = 0;
		while (n > 0) {
			if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) cnt++;
			n /= 10;
		}
		return cnt;
	}
}