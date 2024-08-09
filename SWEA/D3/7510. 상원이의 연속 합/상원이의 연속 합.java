import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int a0 = 1; a0 <= N; a0++) {
				for (int n = 1; n <= (N + 1) / 2; n++) {
					int s = (2 * a0  + n - 1) * n / 2;
					if (s == N) {
						cnt++;
					} else if (s > N) {
						break;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
			System.out.print(sb);
		}
	}
}