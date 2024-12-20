import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{N, 0});
        int[] dijkstra = new int[100001];
        Arrays.fill(dijkstra, INF);
        dijkstra[N] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int currentX = cur[0];
            int currentTime = cur[1];

            if (currentX == K) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nx;
                int ntime;
                switch (i) {
                    case 0:
                        nx = currentX - 1;
                        ntime = currentTime + 1;
                        break;
                    case 1:
                        nx = currentX + 1;
                        ntime = currentTime + 1;
                        break;
                    default:
                        nx = currentX * 2;
                        ntime = currentTime;
                        break;
                }

                if (nx >= 0 && nx <= 100000 && dijkstra[nx] > ntime) {
                    dijkstra[nx] = ntime;
                    pq.offer(new int[]{nx, ntime});
                }
            }
        }
        System.out.println(dijkstra[K]);
    }
}