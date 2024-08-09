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
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;
			}

			int plainNumCnt = 0;
			for (int i = 1; i <= N - 2; i++) {
				int maxNum = Math.max(arr[i - 1], Math.max(arr[i], arr[i + 1]));
				int minNum = Math.min(arr[i - 1], Math.min(arr[i], arr[i + 1]));
				if (arr[i] != maxNum && arr[i] != minNum) {
					plainNumCnt++;
				}
			}
			System.out.println("#" + test_case	+ " " + plainNumCnt);
		}
	}
}