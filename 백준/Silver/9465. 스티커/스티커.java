import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stickers[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stickers[1][j] = Integer.parseInt(st.nextToken());
            }

            if (N == 1) {
                sb.append(Math.max(stickers[0][0], stickers[1][0])).append('\n');
                continue;
            }
            int[][] dp = new int[2][N];
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            dp[0][1] = dp[1][0] + stickers[0][1];
            dp[1][1] = dp[0][0] + stickers[1][1];
            for (int j = 2; j < N; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
            }
            sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append('\n');
        }
        System.out.print(sb);
    }
}
