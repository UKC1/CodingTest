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
    static int[] dijkstra;
    static List<List<City>> cities;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        dijkstra = new int[N + 1];
        cities = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            dijkstra[i] = INF;
            cities.add(new ArrayList<>());
        }
        PriorityQueue<City> pq = new PriorityQueue<>(Comparator.comparingInt(City::getCost));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            cities.get(start).add(new City(end, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        pq.offer(new City(start, 0));
        while (!pq.isEmpty()) {
            City cur = pq.poll();
            int v = cur.vertex;
            int cost = cur.cost;
            
            if (dijkstra[v] < cost) continue; 
            for (City next : cities.get(v)) {
                int newCost = next.getCost() + cost;
                if (dijkstra[next.vertex] > newCost) {
                    dijkstra[next.vertex] = newCost;
                    pq.offer(new City(next.vertex, newCost));
                }
            }
        }
        System.out.println(dijkstra[end]);
    }
}