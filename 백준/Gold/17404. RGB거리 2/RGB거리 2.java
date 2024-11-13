import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] homes = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			homes[i][0] = Integer.parseInt(st.nextToken());
			homes[i][1] = Integer.parseInt(st.nextToken());
			homes[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int minCost = 1000000;
		for (int firstColor = 0; firstColor < 3; firstColor++) {
			int[][] dp = new int[N][3];
			
			for (int i = 0; i < 3; i++) {
				if(i == firstColor) {
					dp[0][i] = homes[0][i];
				} else {
					dp[0][i] = 1000000;
				}
			}
			for (int i = 1; i < N; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + homes[i][0];
				dp[i][1] = Math.min(dp[i-1][2], dp[i-1][0]) + homes[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + homes[i][2];
			}
			for (int lastColor = 0; lastColor < 3; lastColor++) {
				if (firstColor != lastColor) minCost = Math.min(minCost, dp[N-1][lastColor]);
			}
		}
		
		System.out.print(minCost);
		
 	}
}