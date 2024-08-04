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
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int maxUp = 0;
			int maxDown = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] < arr[i + 1]) {
					maxUp = Math.max(maxUp, arr[i + 1] - arr[i]);
				} else if (arr[i] > arr[i + 1]) {
					maxDown = Math.max(maxDown, arr[i] - arr[i + 1]);
				}
			}
			System.out.println("#" + test_case + " " + maxUp + " " + maxDown);
		}
	}
}