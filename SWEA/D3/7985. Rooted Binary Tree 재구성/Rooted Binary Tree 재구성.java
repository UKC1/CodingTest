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
			int K = Integer.parseInt(br.readLine());
			int cnt = (int)Math.pow(2, K) - 1;
			int[] arr = new int[cnt];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cnt; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			StringBuilder sb = new StringBuilder();
			// sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < K; i++) {
				int start = (int)Math.pow(2, i) - 1;
				int interval = (int)Math.pow(2, i + 1);
				for (int j = start; j < arr.length; j+=interval) {
					sb.append(arr[j]).append(" ");
				}
				sb.append("\n");
			}
			String[] sbDownArr = sb.toString().split("\n");
			sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			for (int i = sbDownArr.length - 1; i >= 0; i--) {
				sb.append(sbDownArr[i]).append("\n");
			}
			System.out.print(sb);
		}
	}
}