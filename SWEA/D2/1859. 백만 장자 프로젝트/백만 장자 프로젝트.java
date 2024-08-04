import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			long totalProfit = 0;
			int maxPrice = arr[N-1];

			for (int i = N-2; i >= 0; i--) {
				if (arr[i] > maxPrice) {
					maxPrice = arr[i];
				} else {
					totalProfit += (maxPrice - arr[i]);
				}
			}

			System.out.println("#" + test_case + " " + totalProfit);
		}
	}
}