import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];
        final int MOD = 1000000000;

        // 1자리 수의 초기화 (0을 제외한 1~9는 계단 수가 1개씩 있음)
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // 2자리부터 N자리까지의 계단 수 계산
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % MOD;  // 0은 1에서만 올 수 있음
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % MOD;  // 9는 8에서만 올 수 있음
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;  // 그 외의 경우
                }
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        System.out.print(result);
    }
}