import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class City {
        int vertex;
        int cost;
        City(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }
    }
    static List<List<City>> cities;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        cities = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            cities.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            cities.get(start).add(new City(end, 1));
        }

        int[] dijkstra = new int[N + 1];
        Arrays.fill(dijkstra,INF);
        dijkstra[X] = 0;
        PriorityQueue<City> pq = new PriorityQueue<>(Comparator.comparingInt(City::getCost));
        pq.offer(new City(X, 0));
        while (!pq.isEmpty()) {
            City curr = pq.poll();
            int currentV = curr.vertex;
            int currentCost = curr.cost;

            if (dijkstra[currentV] < currentCost) continue;
            for (City next : cities.get(curr.vertex)) {
                int nextV = next.vertex;
                int nextCost = next.cost + currentCost;
                if (dijkstra[nextV] > nextCost) {
                    dijkstra[nextV] = nextCost;
                    pq.offer(new City(nextV, nextCost));
                }
            }

        }
        for (int i = 1; i <= N; i++) {
            if (dijkstra[i] == K) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb.length() < 2 ? -1 : sb);
    }
}