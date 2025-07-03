import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        /**
         * 이친수
         * 1. 0으로 시작 x
         * 2. 1이 두 번 연속 나타나지 않음
         *
         * 무조건 시작은 1
         * 그 다음 같은 0
         * 피보나치...
         * 1 : 1
         * 2 : 10
         * 3 : 100, 101
         * 4 : 1000, 1010, 1001
         * 5 : 10000, 10100, 10010, 10001, 10101
         */
        long[] dp = new long[91];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.print(dp[N]);
    }
}
