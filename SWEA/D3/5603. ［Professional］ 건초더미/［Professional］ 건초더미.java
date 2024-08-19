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
			int sumHeight = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				sumHeight += arr[i];
			}

			int initialHeight = sumHeight / N;
			int minMoves = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > initialHeight) {
					minMoves += arr[i] - initialHeight;
				}
			}
			System.out.println("#" + test_case + " " + minMoves);

		}
	}
}