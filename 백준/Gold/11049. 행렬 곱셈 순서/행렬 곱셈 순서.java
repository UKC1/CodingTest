import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[][] matrix;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        matrix = new int[N][2];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken()); // 행
            matrix[i][1] = Integer.parseInt(st.nextToken()); // 열
        }

        // dp[i][j]: i번째 행렬부터 j번째 행렬까지의 최소 연산 횟수
        for (int len = 1; len < N; len++) { // 부분 행렬 길이
            for (int i = 0; i + len < N; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + (matrix[i][0] * matrix[k][1] * matrix[j][1]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}