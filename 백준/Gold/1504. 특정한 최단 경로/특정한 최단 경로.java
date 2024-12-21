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

        // 다익스트라 계산
        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(V1);
        int[] distFromV2 = dijkstra(V2);

        // 두 가지 경로의 비용 계산
        long route1 = (long) distFrom1[V1] + distFromV1[V2] + distFromV2[N];
        long route2 = (long) distFrom1[V2] + distFromV2[V1] + distFromV1[N];

        // 최소값 계산 및 출력
        long result = Math.min(route1, route2);
        System.out.println(result >= INF ? -1 : result);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int currentNode = cur[0];
            int currentCost = cur[1];

            if (currentCost > dist[currentNode]) continue;

            for (int[] next : graph.get(currentNode)) {
                int nextNode = next[0];
                int nextCost = next[1];
                int newCost = currentCost + nextCost;

                if (dist[nextNode] > newCost) {
                    dist[nextNode] = newCost;
                    pq.offer(new int[]{nextNode, newCost});
                }
            }
        }

        return dist;
    }
}