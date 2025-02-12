import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine()); // 파일 개수
            int[] files = new int[K + 1]; // 파일 크기 배열
            int[] prefixSum = new int[K + 1]; // 누적 합 배열
            int[][] dp = new int[K + 1][K + 1]; // DP 테이블

            // 파일 크기 입력 및 누적 합 계산
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                prefixSum[i] = prefixSum[i - 1] + files[i]; // 누적합 갱신
            }

            // DP 테이블 채우기
            for (int len = 2; len <= K; len++) { // 부분 파일의 길이 (2부터 시작)
                for (int i = 1; i + len - 1 <= K; i++) {
                    int j = i + len - 1; // 끝 인덱스
                    dp[i][j] = Integer.MAX_VALUE;

                    // k를 기준으로 나눠서 최소 비용 찾기
                    for (int k = i; k < j; k++) {
                        int cost = dp[i][k] + dp[k + 1][j] + (prefixSum[j] - prefixSum[i - 1]);
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }

            // 결과 출력 (전체 파일을 합칠 때 최소 비용)
            System.out.println(dp[1][K]);
        }
    }
}