import java.io.*;
import java.util.*;

public class Main {
    static class City implements Comparable<City> {
        int vertex, cost;

        City(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static List<List<City>> graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int X = Integer.parseInt(st.nextToken()); // 파티가 열리는 도시

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new City(end, cost));
        }

        // X에서 모든 도시로 가는 최단 거리
        int[] distFromX = dijkstra(X, N);

        int maxCost = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue; // 자기 자신으로 가는 경우는 제외
            int[] distToX = dijkstra(i, N);
            maxCost = Math.max(maxCost, distToX[X] + distFromX[i]);
        }

        System.out.println(maxCost);
    }

    static int[] dijkstra(int start, int n) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            City current = pq.poll();
            int currVertex = current.vertex;
            int currCost = current.cost;

            if (currCost > dist[currVertex]) continue;

            for (City neighbor : graph.get(currVertex)) {
                int newCost = currCost + neighbor.cost;
                if (newCost < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newCost;
                    pq.offer(new City(neighbor.vertex, newCost));
                }
            }
        }

        return dist;
    }
}