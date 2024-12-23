import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<int[]>> maps;
    static int[] items;
    static final int INF = Integer.MAX_VALUE;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        items = new int[N + 1];
        maps = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            maps.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            maps.get(start).add(new int[]{end, length});
            maps.get(end).add(new int[]{start, length});
        }

        int maxItems = 0;
        for (int start = 1; start <= N; start++) {
            int[] dist = dijkstra(start);
            int totalItems = 0;

            for (int i = 1; i <= N; i++) {
                if (dist[i] <= M) { // 거리 조건 확인
                    totalItems += items[i];
                }
            }

            maxItems = Math.max(maxItems, totalItems);
        }

        System.out.println(maxItems);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int currentV = cur[0];
            int currentLen = cur[1];

            if (dist[currentV] < currentLen) continue;

            for (int[] next : maps.get(currentV)) {
                int nextV = next[0];
                int nextLen = currentLen + next[1];

                if (nextLen < dist[nextV]) {
                    dist[nextV] = nextLen;
                    pq.offer(new int[]{nextV, nextLen});
                }
            }
        }

        return dist;
    }
}