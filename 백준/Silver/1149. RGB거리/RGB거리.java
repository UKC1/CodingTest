import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] colors = new int[N][3];
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());
			colors[i][0] = red;
			colors[i][1] = green;
			colors[i][2] = blue;
		}
		for (int i = 0; i < 3; i++) {
			dp[0][i] = colors[0][i];
		}
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + colors[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + colors[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + colors[i][2];
		}

		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			minCost = Math.min(minCost, dp[N - 1][i]);
		}
		System.out.println(minCost);

    }
}
