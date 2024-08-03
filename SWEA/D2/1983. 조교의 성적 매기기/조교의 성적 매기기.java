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
		String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int middleScore = Integer.parseInt(st.nextToken());
				int finalScore = Integer.parseInt(st.nextToken());
				int homeWork = Integer.parseInt(st.nextToken());
				score[i] = middleScore * 35 + finalScore * 45 + homeWork * 20;
			}
			int kScore = score[K - 1];
			int kIdx = 0;
			Arrays.sort(score);
			for (int i = 0; i < score.length; i++) {
				if (kScore == score[i]) {
					kIdx = i;
					break;
				}
			}

			int idx = 0;
			while (kIdx > 0) {
				kIdx -= N / 10;
				idx++;
			}
			
			if (kIdx < 0) idx--;
			System.out.println("#" + test_case + " " + grades[10 - idx - 1]);
		}
	}
}