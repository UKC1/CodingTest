import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] houses;
    static final int INF = 1000 * 1000 + 1;  // 큰 값으로 초기화

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        houses = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minCost = INF;

        // 첫 번째 집의 색깔을 고정하고 DP 수행
        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[N][3];

            // 첫 번째 집 색 고정하고 나머지 색은 큰 값으로 설정
            for (int i = 0; i < 3; i++) {
                if (i == firstColor) {
                    dp[0][i] = houses[0][i];
                } else {
                    dp[0][i] = INF;
                }
            }

            // DP 수행
            for (int i = 1; i < N; i++) {
                dp[i][0] = houses[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = houses[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = houses[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }

            // 첫 번째 집 색상과 다른 색상 중에서 최소값 선택
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (firstColor != lastColor) {
                    minCost = Math.min(minCost, dp[N - 1][lastColor]);
                }
            }
        }

        System.out.println(minCost);
    }
}