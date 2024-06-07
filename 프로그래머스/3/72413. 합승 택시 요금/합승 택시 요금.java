import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int INF = 100000000;
        List<int[]>[] graph = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 생성
        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        
        // 다익스트라 알고리즘을 사용하여 최단 거리 계산
        int[] distFromS = dijkstra(s, graph, n);
        int[] distFromA = dijkstra(a, graph, n);
        int[] distFromB = dijkstra(b, graph, n);
        
        int answer = INF;
        
        // 모든 노드 k를 거쳐 가는 경우의 최소 비용 계산
        for (int k = 1; k <= n; k++) {
            answer = Math.min(answer, distFromS[k] + distFromA[k] + distFromB[k]);
        }
        
        return answer;
    }
    
    private int[] dijkstra(int start, List<int[]>[] graph, int n) {
        final int INF = 100000000;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];
            
            if (currentDist > dist[currentNode]) continue;
            
            for (int[] neighbor : graph[currentNode]) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int distance = currentDist + weight;
                
                if (distance < dist[nextNode]) {
                    dist[nextNode] = distance;
                    pq.offer(new int[]{nextNode, distance});
                }
            }
        }
        
        return dist;
    }
}