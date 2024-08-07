import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Integer[] sortedScores = new Integer[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				sortedScores[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(sortedScores, (o1, o2) -> o2 - o1);
			int sum = 0;
			for (int i = 0; i < K; i++) {
				sum += sortedScores[i];
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}