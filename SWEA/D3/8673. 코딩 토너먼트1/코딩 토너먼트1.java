import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			int K = Integer.parseInt(br.readLine().trim());
			int totalGames = (int) Math.pow(2, K);

			int[] players = new int[totalGames];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < totalGames; i++) {
				players[i] = Integer.parseInt(st.nextToken());
			}

			int totalScore = 0;
			while (totalGames > 1) {
				for (int i = 0; i < totalGames; i += 2) {
					int diff = Math.abs(players[i] - players[i + 1]);
					totalScore += diff;
					players[i / 2] = Math.max(players[i], players[i + 1]);
				}
				totalGames /= 2;
			}
			System.out.println("#" + test_case + " " + totalScore);
		}
	}
}