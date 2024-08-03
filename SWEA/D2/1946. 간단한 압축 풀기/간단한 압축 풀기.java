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
			char[] charStr = new char[N];
			int[] count = new int[N];
			int totalCount = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				charStr[i] = st.nextToken().charAt(0);
				count[i] = Integer.parseInt(st.nextToken());
				totalCount += count[i];
			}
			int cnt = 0;
			int idx = 0;
			System.out.println("#" + test_case);
			while (cnt < totalCount) {
				for (int i = 0; i < 10; i++) {
					if (count[idx] > 0) {
						System.out.print(charStr[idx]);
						count[idx] --;
						cnt++;
					} else {
						idx++;
						if (idx == N) break;
						i--;
					}
				}
				System.out.println();
			}
		}
	}
}