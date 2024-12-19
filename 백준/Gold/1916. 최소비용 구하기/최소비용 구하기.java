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
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dijkstra = new int[N + 1];
        cities = new ArrayList<List<City>>();
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
        st = new StringTokenizer(br.readLine());
        int startV = Integer.parseInt(st.nextToken());
        int endV = Integer.parseInt(st.nextToken());
        PriorityQueue<City> pq = new PriorityQueue<City>(Comparator.comparingInt(City::getCost));
        pq.offer(new City(startV, 0));
        while (!pq.isEmpty()) {
            City curr = pq.poll();
            int curV = curr.vertex;
            int curCost = curr.cost;

            if (dijkstra[curV] < curCost) continue;
            for (City next : cities.get(curV)) {
                int newCost = curCost + next.cost;
                if (newCost < dijkstra[next.vertex]) {
                    dijkstra[next.vertex] = newCost;
                    pq.offer(new City(next.vertex, newCost));
                }
            }
        }
        System.out.print(dijkstra[endV]);
    }
}