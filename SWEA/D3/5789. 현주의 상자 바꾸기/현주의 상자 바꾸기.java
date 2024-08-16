import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int[] arr = new int[N + 1];
			for (int i = 1; i <= Q; i++) {
				st = new StringTokenizer(br.readLine());
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				for (int idx = L; idx <= R; idx++) {
					arr[idx] = i;
				}
			}
			sb.append("#").append(test_case);
			for(int i = 1; i <= N; i++) {
				sb.append(" ").append(arr[i]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}