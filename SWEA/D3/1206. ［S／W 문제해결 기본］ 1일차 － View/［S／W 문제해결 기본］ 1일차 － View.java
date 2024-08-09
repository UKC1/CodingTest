import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int viewCnt = 0;
			for (int i = 2; i < N - 2; i++) {
				int leftMax = arr[i - 2] > arr[i - 1] ? arr[i - 2] : arr[i - 1];
				int rightMax = arr[i + 2] > arr[i + 1] ? arr[i + 2] : arr[i + 1];
				int maxBuild = leftMax > rightMax ? leftMax : rightMax;
				if (arr[i] > maxBuild) {
					viewCnt += arr[i] - maxBuild;
				}
			}
			sb.append("#").append(test_case).append(" ").append(viewCnt).append("\n");
		}
		System.out.print(sb);
	}
}