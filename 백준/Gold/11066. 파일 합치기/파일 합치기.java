import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            int[] files = new int[K + 1]; // 파일 크기 배열
            int[] prefixSum = new int[K + 1]; // 누적 합 배열
            int[][] dp = new int[K + 1][K + 1]; // DP 테이블
            int[][] opt = new int[K + 1][K + 1]; // 최적 분할 위치

            // 입력 및 누적 합 계산
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                prefixSum[i] = prefixSum[i - 1] + files[i]; // 누적합 계산
                opt[i][i] = i; // 초기 최적 분할 위치
            }

            // DP 테이블 채우기 (Knuth Optimization 적용)
            for (int len = 2; len <= K; len++) { // 구간 길이
                for (int i = 1; i + len - 1 <= K; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    int start = opt[i][j - 1]; // 이전 구간의 최적 k
                    int end = Math.min(j - 1, opt[i + 1][j]); // 다음 구간의 최적 k
                    for (int k = start; k <= end; k++) {
                        int cost = dp[i][k] + dp[k + 1][j] + (prefixSum[j] - prefixSum[i - 1]);
                        if (cost < dp[i][j]) {
                            dp[i][j] = cost;
                            opt[i][j] = k; // 최적 분할 위치 갱신
                        }
                    }
                }
            }

            // 결과 출력
            System.out.println(dp[1][K]);
        }
    }
}