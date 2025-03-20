import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];

        // dp[1]은 0 (1은 이미 1이기 때문에 연산이 필요 없음)
        for (int i = 2; i <= N; i++) {
            // 기본적으로 1을 빼는 연산
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어질 때
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어질 때
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.print(dp[N]);
    }
}
