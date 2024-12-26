import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static char[][] maps;
    static int[][] dijkstra;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new char[N][N];
        dijkstra = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                maps[i][j] = str.charAt(j);
                dijkstra[i][j] = INF;
            }
        }
        // 0은 검은 방
        // 1은 흰 방
        // 흰 방으로 바꾸어야 할 최소의 검은 방의 수를 출력
        // 시작은 0 0 => 끝은 N N 둘 다 모두 1 흰 방
        // 해당 위치로 가는 최소 횟수를 구해야 함
        dijkstra[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (dijkstra[x][y] < dist) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int nextDist = dist;
                    if (maps[nx][ny] == '0') {
                        nextDist++;
                    }
                    if (dijkstra[nx][ny] > nextDist) {
                        dijkstra[nx][ny] = nextDist;
                        pq.offer(new int[]{nx, ny, nextDist});
                    }
                }
            }
        }
        System.out.println(dijkstra[N - 1][N - 1]);
    }
}