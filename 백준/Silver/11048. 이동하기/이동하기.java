import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 행의 개수
        int m = Integer.parseInt(st.nextToken());  // 열의 개수

        int[][] dp = new int[n + 1][m + 1];  // dp 배열
        int[][] a = new int[n + 1][m + 1];   // 입력값 저장 배열

        // 입력값을 2차원 배열에 저장
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp를 사용한 최댓값 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + a[i][j];
            }
        }

        System.out.print(dp[n][m]);
    }
}