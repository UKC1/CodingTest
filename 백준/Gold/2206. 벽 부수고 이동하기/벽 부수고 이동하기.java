import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] maps;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2]; // 0: 벽 안 부숨, 1: 벽 부숨
        queue.offer(new int[]{0, 0, 1, 0}); // x, y, 거리, 벽 부순 여부
        visited[0][0][0] = true; 

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2], brokenWall = cur[3];

            if (x == N - 1 && y == M - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (maps[nx][ny] == 0 && !visited[nx][ny][brokenWall]) { 
                        // 이동 가능 & 해당 상태에서 방문한 적 없으면
                        visited[nx][ny][brokenWall] = true;
                        queue.offer(new int[]{nx, ny, dist + 1, brokenWall});
                    } else if (maps[nx][ny] == 1 && brokenWall == 0) { 
                        // 벽이면서, 아직 벽을 부순 적 없을 때
                        visited[nx][ny][1] = true;
                        queue.offer(new int[]{nx, ny, dist + 1, 1});
                    }
                }
            }
        }
        return -1;
    }
}
