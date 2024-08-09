import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // DP 배열 초기화
        int[] dp = new int[N + 1];
        
        // 초기값 설정 (임의의 큰 값으로 설정)
        for (int i = 0; i <= N; i++) {
            dp[i] = 5000;  // N의 최대값은 5000 이하임
        }

        // 3kg와 5kg 봉지로 만들 수 있는 경우 초기화
        if (N >= 3) dp[3] = 1;
        if (N >= 5) dp[5] = 1;

        // DP를 통해 최소 봉지 수 계산
        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }

        // 결과 출력
        if (dp[N] >= 5000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}