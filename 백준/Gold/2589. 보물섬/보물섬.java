import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char[][] maps;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int maxCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new char[N][M];
        for (int i = 0; i < N; i++) {
            maps[i] = br.readLine().toCharArray();
        }
        maxCnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(maxCnt);
    }
    static char[][] mapCopy() {
        char[][] copyMap = new char[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(maps[i], 0, copyMap[i], 0, M);
        }
        return copyMap;
    }
    static void bfs(int x, int y) {
        char[][] copyMaps = mapCopy();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 0});
        copyMaps[x][y] = 'W';
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int cnt = cur[2];
            maxCnt = Math.max(maxCnt, cnt);
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && copyMaps[nx][ny] == 'L') {
                    copyMaps[nx][ny] = 'W';
                    queue.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }
    }
}