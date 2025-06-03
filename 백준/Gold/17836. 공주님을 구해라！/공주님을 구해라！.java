import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int T;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] maps = new int[N][M];
        int wx = -1;
        int wy = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 2) {
                    wx = i;
                    wy = j;
                }
            }
        }

        int basicTime = bfs(maps, N - 1, M - 1);
        int weaponTime = bfs(maps, wx, wy);
        int diff = Math.abs(N - 1 - wx) + Math.abs(M - 1 - wy);

        int answer = Math.min(basicTime, weaponTime + diff);
        System.out.print(answer == T + 1 ? "Fail" : answer);
    }

    static int bfs(int[][] maps, int targetX, int targetY) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];
            if (time > T) {
                break;
            }

            if (x == targetX && y == targetY) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (maps[nx][ny] != 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, time + 1});
                }
            }
        }
        return T + 1;
    }
}
