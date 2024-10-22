import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static char[][] maps;
    static int[][] bDiff, wDiff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        maps = new char[N][M];
        for (int i = 0; i < N; i++) {
            maps[i] = br.readLine().toCharArray();
        }

        bDiff = new int[N + 1][M + 1];
        wDiff = new int[N + 1][M + 1];

        // 누적합 배열 초기화 (B로 시작하는 경우와 W로 시작하는 경우)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((i + j) % 2 == 0) {
                    // (i + j) % 2 == 0이면 해당 위치는 B여야 함
                    if (maps[i][j] != 'B') bDiff[i + 1][j + 1]++;
                    if (maps[i][j] != 'W') wDiff[i + 1][j + 1]++;
                } else {
                    // (i + j) % 2 == 1이면 해당 위치는 W여야 함
                    if (maps[i][j] != 'W') bDiff[i + 1][j + 1]++;
                    if (maps[i][j] != 'B') wDiff[i + 1][j + 1]++;
                }
                // 누적합 계산
                bDiff[i + 1][j + 1] += bDiff[i][j + 1] + bDiff[i + 1][j] - bDiff[i][j];
                wDiff[i + 1][j + 1] += wDiff[i][j + 1] + wDiff[i + 1][j] - wDiff[i][j];
            }
        }

        int minCnt = Integer.MAX_VALUE;
        // K x K 체스판의 최소 칠하기 횟수 계산
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int bCnt = bDiff[i][j] - bDiff[i - K][j] - bDiff[i][j - K] + bDiff[i - K][j - K];
                int wCnt = wDiff[i][j] - wDiff[i - K][j] - wDiff[i][j - K] + wDiff[i - K][j - K];
                minCnt = Math.min(minCnt, Math.min(bCnt, wCnt));
            }
        }

        System.out.print(minCnt);
    }
}