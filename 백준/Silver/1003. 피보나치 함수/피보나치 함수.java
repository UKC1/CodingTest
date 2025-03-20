import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[41][2];
        dp[0][0] = 1; dp[0][1] = 0;  // fibonacci(0)의 결과
        dp[1][0] = 0; dp[1][1] = 1;  // fibonacci(1)의 결과

        // DP 배열 미리 계산 (O(40))
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }

        System.out.print(sb);
    }
}
