import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int totalCount; // 총 퀸 배치 방법 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        totalCount = 0;

        // 비트마스킹 기반 DFS 탐색
        dfs(0, N, 0, 0, 0);

        // 결과 출력
        System.out.println(totalCount);
    }

    static void dfs(int row, int N, int cols, int d1, int d2) {
        // 모든 퀸을 배치한 경우
        if (row == N) {
            totalCount++;
            return;
        }

        // 가능한 위치 계산
        int availablePositions = (~(cols | d1 | d2)) & ((1 << N) - 1);

        while (availablePositions != 0) {
            // 가장 오른쪽 비트를 선택
            int position = availablePositions & -availablePositions;

            // 해당 위치에 퀸 배치
            dfs(row + 1, N, cols | position, (d1 | position) << 1, (d2 | position) >> 1);

            // 상태 복원
            availablePositions &= (availablePositions - 1);
        }
    }
}