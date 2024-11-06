import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        StringBuilder sb = new StringBuilder();

        while (!(str = br.readLine()).equals("0")) {
            int N = Integer.parseInt(str);
            cnt++;
            int[][] maps = new int[N][N];
            int[][] dijkstra = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                    dijkstra[i][j] = INF;
                }
            }

            dijkstra[0][0] = maps[0][0];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            pq.offer(new int[]{0, 0, dijkstra[0][0]});

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int x = current[0];
                int y = current[1];
                int cost = current[2];

                if (cost > dijkstra[x][y]) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        int newCost = maps[nx][ny] + cost;
                        if (newCost < dijkstra[nx][ny]) {
                            dijkstra[nx][ny] = newCost;
                            pq.offer(new int[]{nx, ny, newCost});
                        }
                    }
                }
            }

            sb.append("Problem ").append(cnt).append(": ").append(dijkstra[N - 1][N - 1]).append("\n");
        }
        System.out.print(sb);
    }
}