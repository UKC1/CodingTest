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
			int[] scores = new int[101];
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				scores[Integer.parseInt(st.nextToken())]++;
			}

			int maxCntNumIdx = 0;
			int maxCntNum = -1;
			for (int i = 0; i < scores.length; i++) {
				if (maxCntNum <= scores[i]) {
					maxCntNum = scores[i];
					maxCntNumIdx = i;
				}
			}
			System.out.println("#" + test_case + " " + maxCntNumIdx);
		}

	}
}