import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] maps;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        int startX = -1, startY = -1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 9) {
                    startX = i;
                    startY = j;
                    maps[i][j] = 0;
                }
            }
        }

        System.out.println(simulate(startX, startY));
    }

    static int simulate(int startX, int startY) {
        int size = 2, eatCount = 0, time = 0;

        while (true) {
            int[] target = bfs(startX, startY, size);
            if (target == null) break; // 먹을 물고기가 없으면 종료

            int nx = target[0], ny = target[1], dist = target[2];
            time += dist;
            eatCount++;
            if (eatCount == size) { // 크기 증가 조건
                size++;
                eatCount = 0;
            }
            startX = nx;
            startY = ny;
            maps[nx][ny] = 0;
        }

        return time;
    }

    static int[] bfs(int startX, int startY, int size) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                a[2] == b[2] ? (a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]))
                        : Integer.compare(a[2], b[2])
        );
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (maps[x][y] > 0 && maps[x][y] < size) {
                pq.offer(new int[]{x, y, dist});
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && maps[nx][ny] <= size) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return pq.isEmpty() ? null : pq.poll();
    }
}