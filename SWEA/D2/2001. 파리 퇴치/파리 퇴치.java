import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 배열의 크기
            int M = Integer.parseInt(st.nextToken()); // 파리채의 크기
            int[][] arr = new int[N][N];

            // 입력 처리
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 2차원 누적 합 배열 생성
            int[][] prefixSum = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    prefixSum[i][j] = arr[i - 1][j - 1]
                                    + prefixSum[i - 1][j]
                                    + prefixSum[i][j - 1]
                                    - prefixSum[i - 1][j - 1];
                }
            }

            int maxKillSum = 0;

            // 부분 배열의 합 계산
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int x1 = i, y1 = j;
                    int x2 = i + M - 1, y2 = j + M - 1;
                    int flyKillSum = prefixSum[x2 + 1][y2 + 1]
                                   - prefixSum[x1][y2 + 1]
                                   - prefixSum[x2 + 1][y1]
                                   + prefixSum[x1][y1];
                    maxKillSum = Math.max(maxKillSum, flyKillSum);
                }
            }

            System.out.println("#" + test_case + " " + maxKillSum);
        }
    }
}