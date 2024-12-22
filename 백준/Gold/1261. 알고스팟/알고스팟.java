import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char[][] maps;
    static int[][] dijkstra;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        maps = new char[N][M];
        dijkstra = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = str.charAt(j);
                dijkstra[i][j] = INF;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[] {0, 0, 0});
        dijkstra[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], cnt = cur[2];
            if (dijkstra[x][y] < cnt) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int nextCnt = cnt;
                    if (maps[nx][ny] == '1') {
                        nextCnt = cnt + 1;
                    }
                    if (dijkstra[nx][ny] > nextCnt) {
                        dijkstra[nx][ny] = nextCnt;
                        pq.offer(new int[] {nx, ny, nextCnt});
                    }
                }
            }
        }
        System.out.println(dijkstra[N-1][M-1]);

    }
}