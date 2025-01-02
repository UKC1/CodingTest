import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] t, p; // t[i]: 상담 기간, p[i]: 상담 수익
    static int[] dp;   // dp[i]: i번째 날까지 얻을 수 있는 최대 수익

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        t = new int[N + 1];
        p = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken()); // 상담 기간
            p[i] = Integer.parseInt(st.nextToken()); // 상담 수익
        }
        
        for (int i = 1; i <= N; i++) {
            // 이전 날까지의 최대 수익을 갱신
            dp[i] = Math.max(dp[i], dp[i - 1]);

            // 상담을 선택하는 경우
            if (i + t[i] - 1 <= N) {
                dp[i + t[i] - 1] = Math.max(dp[i + t[i] - 1], dp[i - 1] + p[i]);
            }
        }

        System.out.println(dp[N]);
    }
}