import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] maps = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        // O : 빈공간
        // X : 벽
        // I : 도연이
        // P : 사람
        int startX = 0, startY = 0;
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maps[i][j] = line[j];
                if (line[j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }
        int cnt = bfs(maps, visited, startX, startY);
        System.out.print(cnt == 0 ? "TT" : cnt);
    }

    static int bfs(char[][] maps, boolean[][] visited, int x, int y) {
        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int currX = cur[0], currY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = currX + dx[i], ny = currY + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (maps[nx][ny] == 'O' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                } else if (maps[nx][ny] == 'P' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    cnt++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return cnt;
    }
}

