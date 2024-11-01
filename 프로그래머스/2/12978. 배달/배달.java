import java.util.*;

class Solution {
    int INF = (int) 1e9; // 무한을 의미하는 값
    ArrayList<ArrayList<Node>> graph;
    int[] distances;
    
    class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int start = 1; // 시작 노드 번호

        // 그래프 및 거리 배열 초기화
        graph = new ArrayList<>();
        distances = new int[N + 1];
        Arrays.fill(distances, INF);
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 그래프 구축
        for (int i = 0; i < road.length; i++) {
            int u = road[i][0];
            int v = road[i][1];
            int w = road[i][2];
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w)); // 양방향 추가
        }

        // 다익스트라 알고리즘 실행
        dijkstra(start, K);

        // 도달 가능한 노드의 수 세기
        for (int i = 1; i <= N; i++) {
            if (distances[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dijkstra(int start, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;

            if (distances[now] < dist) continue;

            for (Node nextNode : graph.get(now)) {
                int cost = distances[now] + nextNode.distance;
                if (cost <= K && cost < distances[nextNode.index]) {
                    distances[nextNode.index] = cost;
                    pq.offer(new Node(nextNode.index, cost));
                }
            }
        }
    }
}
