import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
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

        System.out.println(zeroOneBFS());
    }

    static int zeroOneBFS() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        dijkstra[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int nextCost = dijkstra[x][y] + (maps[nx][ny] == '1' ? 1 : 0);

                    if (nextCost < dijkstra[nx][ny]) {
                        dijkstra[nx][ny] = nextCost;

                        if (maps[nx][ny] == '1') {
                            deque.offerLast(new int[]{nx, ny}); // 벽을 부수는 경우 뒤쪽에 삽입
                        } else {
                            deque.offerFirst(new int[]{nx, ny}); // 빈 방인 경우 앞쪽에 삽입
                        }
                    }
                }
            }
        }

        return dijkstra[N - 1][M - 1];
    }
}