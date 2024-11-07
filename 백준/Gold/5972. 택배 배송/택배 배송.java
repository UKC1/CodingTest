import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static class Edge {
        int v, w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        int getW() {
            return this.w;
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        int[] dijkstra = new int[N + 1];
        Arrays.fill(dijkstra, INF);
        dijkstra[1] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getW));
        pq.offer(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int v = current.v;
            int w = current.w;
            if (dijkstra[v] < w) continue;

            for(Edge edge : graph.get(v)) {
                int ev = edge.v;
                int ew = edge.w;
                if (dijkstra[ev] > ew + dijkstra[v]) {
                    dijkstra[ev] = ew + dijkstra[v];
                    pq.offer(edge);
                }
            }
        }
        System.out.print(dijkstra[N]);
    }
}