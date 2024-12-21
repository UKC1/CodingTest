import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<List<int[]>> graph;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new int[]{end, cost});
            graph.get(end).add(new int[]{start, cost});
        }
        st = new StringTokenizer(br.readLine());
        int V1 = Integer.parseInt(st.nextToken());
        int V2 = Integer.parseInt(st.nextToken());
        // 1 -> N으로 최단 거리로 이동
        // V1과 V2은 반드시 거쳐가야 함
        int[] dijkstraOne = dijkstraCalculate(1);
        int[] dijkstraV1 = dijkstraCalculate(V1);
        int[] dijkstraV2 = dijkstraCalculate(V2);
        // 1. 1 -> V1 -> V2 -> N
        int sumOneV1V2N = dijkstraOne[V1] + dijkstraV1[V2] + dijkstraV2[N];
        // 2. 1 -> V2 -> V1 -> N
        int sumOneV2V1N = dijkstraOne[V2] + dijkstraV2[V1] + dijkstraV1[N];
        if ((dijkstraOne[V1] == INF || dijkstraV1[V2] == INF || dijkstraV2[N] == INF)
        && (dijkstraOne[V2] == INF || dijkstraV2[V1] == INF || dijkstraV1[N] == INF)) {
            System.out.print(-1);
        } else {
            System.out.print(Math.min(sumOneV1V2N, sumOneV2V1N));
        }

    }

    static int[] dijkstraCalculate(int V) {
        int[] dijkstra = new int[N + 1];
        Arrays.fill(dijkstra, INF);
        dijkstra[V] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {V, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int currentV = cur[0];
            int currentCost = cur[1];

            if (dijkstra[currentV] < currentCost) continue;

            for (int[] next : graph.get(currentV)) {
                int nextV = next[0];
                int nextCost = next[1];

                int newCost = currentCost + nextCost;
                if (dijkstra[nextV] > newCost) {
                    dijkstra[nextV] = newCost;
                    pq.offer(new int[] {nextV, newCost});
                }
            }
        }
        return dijkstra;
    }
}