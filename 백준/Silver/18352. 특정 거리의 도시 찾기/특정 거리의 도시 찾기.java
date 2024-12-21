import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(new City(end, 1));
        }
        sb = new StringBuilder();
        dijkstra(N, X, K);
        System.out.print(sb.length() < 2 ? -1 : sb);
    }

    static void dijkstra(int n, int start, int targetDistance) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            City current = pq.poll();
            int currentVertex = current.vertex;
            int currentCost = current.cost;

            if (currentCost > dist[currentVertex]) continue;

            for (City neighbor : graph.get(currentVertex)) {
                int nextVertex = neighbor.vertex;
                int newCost = currentCost + neighbor.cost;

                if (dist[nextVertex] > newCost) {
                    dist[nextVertex] = newCost;
                    pq.offer(new City(nextVertex, newCost));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (dist[i] == targetDistance) {
                sb.append(i).append('\n');
            }
        }
    }
}