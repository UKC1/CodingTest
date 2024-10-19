import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] grapes = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            grapes[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.print(grapes[1]);
            return;
        }

        int[] dp = new int[N + 1];  // dp 테이블 생성

        dp[1] = grapes[1];
        if (N >= 2) {
            dp[2] = grapes[1] + grapes[2];
        }

        // DP 점화식 계산
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grapes[i], dp[i - 3] + grapes[i - 1] + grapes[i]));
        }

        System.out.print(dp[N]);
    }
}