import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, -1, 1, -2 ,2, -2, 2};
    static int[] dy = {2, 2, -2, -2, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int cnt = bfs(N, startX, startY, endX, endY);
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    static int bfs(int N, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[N][N];
        visited[startX][startY] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int cnt = cur[2];
            if (curX == endX && curY == endY) {
                return cnt;
            }

            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        return 0;
    }
}
