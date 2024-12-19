import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int vertex;
        int cost;
        public Point(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(br.readLine());
        int[] dijkstra = new int[V + 1];
        List<List<Point>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            dijkstra[i] = INF;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Point(end, cost));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(Point::getCost));
        pq.add(new Point(startV, 0));
        while(!pq.isEmpty()) {
            Point cur = pq.poll();
            int curV = cur.vertex;
            int curCost = cur.cost;

            if (dijkstra[curV] < curCost) continue;

            for (Point nextV : graph.get(curV)) {
                int nextVCost = nextV.cost + curCost;
                if (dijkstra[nextV.vertex] > nextVCost) {
                    dijkstra[nextV.vertex] = nextVCost;
                    pq.add(new Point(nextV.vertex, nextVCost));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (i == startV) {
                sb.append(0).append('\n');
            } else if (dijkstra[i] == INF) {
                sb.append("INF").append('\n');
            } else {
                sb.append(dijkstra[i]).append('\n');
            }
        }

        System.out.print(sb);
    }
}