import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, minBlindSpot = Integer.MAX_VALUE;
    static int[][] map;
    static List<int[]> cctvs = new ArrayList<>();
    static int[][][] directions = {
            {}, // CCTV 0번 없음
            {{0}, {1}, {2}, {3}},             // CCTV 1번: 상, 하, 좌, 우
            {{0, 1}, {2, 3}},                 // CCTV 2번: 상하, 좌우
            {{0, 3}, {1, 3}, {1, 2}, {0, 2}}, // CCTV 3번: 상우, 우하, 하좌, 좌상
            {{0, 1, 3}, {1, 2, 3}, {0, 2, 3}, {0, 1, 2}}, // CCTV 4번
            {{0, 1, 2, 3}}                    // CCTV 5번: 모든 방향
    };
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 입력 처리 및 CCTV 정보 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(new int[]{i, j, map[i][j]}); // CCTV 좌표 및 유형 저장
                }
            }
        }

        // DFS 탐색 시작
        dfs(0);
        System.out.println(minBlindSpot);
    }

    // DFS로 모든 CCTV 조합 탐색
    static void dfs(int idx) {
        if (idx == cctvs.size()) {
            minBlindSpot = Math.min(minBlindSpot, calculateBlindSpot());
            return;
        }

        int[] cctv = cctvs.get(idx);
        int x = cctv[0], y = cctv[1], type = cctv[2];

        for (int[] dirs : directions[type]) {
            setDirections(x, y, dirs, true); // 감시 영역 설정
            dfs(idx + 1);                   // 다음 CCTV 탐색
            setDirections(x, y, dirs, false); // 감시 영역 복구
        }
    }

    // CCTV 감시 영역 설정 및 복구
    static void setDirections(int x, int y, int[] dirs, boolean isSet) {
        for (int dir : dirs) {
            int nx = x, ny = y;
            while (true) {
                nx += dx[dir];
                ny += dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6) break; // 범위 초과 or 벽
                if (map[nx][ny] > 0) continue; // 다른 CCTV 또는 이미 감시된 영역
                map[nx][ny] += isSet ? -1 : 1;  // 감시 설정(-1) 또는 복구(+1)
            }
        }
    }

    // 사각지대 계산
    static int calculateBlindSpot() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }
}