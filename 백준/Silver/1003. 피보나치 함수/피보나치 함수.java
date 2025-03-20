import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int zeroCnt;
	static int oneCnt;
	static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		dp = new int[41][2];
		dp[0][0] = 1;
		for (int i = 1; i <= 40; i++) {
			zeroCnt = 0;
			oneCnt = 0;
			fibonacci(i);
			dp[i][0] = zeroCnt;
			dp[i][1] = oneCnt;
		}

		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
		}
		System.out.print(sb);
    }

	static int fibonacci(int n) {
		if (n == 0) {
			zeroCnt++;
			return 0;
		} else if (n == 1) {
			oneCnt++;
			return 1;
		} else {

			if (dp[n - 2][0] != 0 || dp[n - 2][1] != 0) {
				zeroCnt = dp[n - 2][0] + dp[n - 1][0];
				oneCnt = dp[n - 2][1] + dp[n - 1][1];
				return 0;
			}
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}

