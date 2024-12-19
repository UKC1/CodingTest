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
        int X = Integer.parseInt(st.nextToken());
        cities = new ArrayList<List<City>>();
        int[] dijkstra = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            cities.add(new ArrayList<>());
            dijkstra[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            cities.get(start).add(new City(end, cost));
        }

        int maxCost = 0;
        for (int i = 1; i <= N; i++) {
            int[] goMap = Arrays.copyOf(dijkstra, N + 1);
            int goCost = calculateDijkstra(goMap, i, X);
            int[] backMap = Arrays.copyOf(dijkstra, N + 1);
            int backCost = calculateDijkstra(backMap, X, i);

            maxCost = Math.max(maxCost, goCost + backCost);
        }
        System.out.println(maxCost);
    }

    static int calculateDijkstra(int[] dijkstra, int start, int end) {

        PriorityQueue<City> pq = new PriorityQueue<>(Comparator.comparingInt(City::getCost));
        pq.offer(new City(start, 0));
        dijkstra[start] = 0;
        while (!pq.isEmpty()) {
            City curr = pq.poll();
            int currV = curr.vertex;
            int currCost = curr.cost;

            if (dijkstra[currV] < currCost) continue;

            for (City next : cities.get(currV)) {
                int newCost = next.cost + currCost;
                if (newCost < dijkstra[next.vertex]) {
                    dijkstra[next.vertex] = newCost;
                    pq.offer(new City(next.vertex, newCost));
                }
            }
        }

        return dijkstra[end];
    }
}