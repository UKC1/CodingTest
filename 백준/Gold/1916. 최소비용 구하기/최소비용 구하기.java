import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int city, cost;
        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        // 인접 리스트로 그래프 구성
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        // 다익스트라 알고리즘 실행
        int[] dist = dijkstra(N, graph, startCity);

        // 최소 비용 출력
        System.out.println(dist[endCity]);
    }

    static int[] dijkstra(int N, List<List<Node>> graph, int startCity) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startCity] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startCity, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentCity = current.city;
            int currentCost = current.cost;

            if (dist[currentCity] < currentCost) continue;

            for (Node neighbor : graph.get(currentCity)) {
                int nextCity = neighbor.city;
                int nextCost = currentCost + neighbor.cost;

                if (dist[nextCity] > nextCost) {
                    dist[nextCity] = nextCost;
                    pq.offer(new Node(nextCity, nextCost));
                }
            }
        }

        return dist;
    }
}