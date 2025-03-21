import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        static int N;
        static List<List<Point>> graph;
        static final int INF = Integer.MAX_VALUE;
        static class Point implements Comparable<Point> {
            int vertex;
            int cost;
            Point(int vertex, int cost) {
                this.vertex = vertex;
                this.cost = cost;
            }

            public int getCost() {
                return cost;
            }

            @Override
            public int compareTo(Point o) {
                return cost - o.cost;
            }
        }
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
                graph.get(start).add(new Point(end, cost));
                graph.get(end).add(new Point(start, cost));
            }
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            // 1 -> N으로 최단 거리로 이동
            // V1과 V2은 반드시 거쳐가야 함
            int[] dijkstraOne = dijkstraCalculate(1);
            int[] dijkstraV1 = dijkstraCalculate(V1);
            int[] dijkstraV2 = dijkstraCalculate(V2);

            if ((dijkstraOne[V1] == INF || dijkstraV1[V2] == INF || dijkstraV2[N] == INF)
                    && (dijkstraOne[V2] == INF || dijkstraV2[V1] == INF || dijkstraV1[N] == INF)) {
                System.out.print(-1);
            } else {
                int sumV1V2 = dijkstraOne[V1] + dijkstraV1[V2] + dijkstraV2[N];
                int sumV2V1 = dijkstraOne[V2] + dijkstraV2[V1] + dijkstraV1[N];
                System.out.print(Math.min(sumV1V2, sumV2V1));
            }
        }

        static int[] dijkstraCalculate(int V) {
            int[] dijkstra = new int[N + 1];
            Arrays.fill(dijkstra, INF);
            dijkstra[V] = 0;

            PriorityQueue<Point> pq = new PriorityQueue<>();
            pq.offer(new Point(V, 0));
            while (!pq.isEmpty()) {
                Point cur = pq.poll();
                int currentV = cur.vertex;
                int currentCost = cur.cost;

                if (dijkstra[currentV] < currentCost) continue;

                for (Point next : graph.get(currentV)) {
                    int nextV = next.vertex;
                    int nextCost = next.cost;

                    int newCost = currentCost + nextCost;
                    if (dijkstra[nextV] > newCost) {
                        dijkstra[nextV] = newCost;
                        pq.offer(new Point (nextV, newCost));
                    }
                }
            }
            return dijkstra;
        }
    }