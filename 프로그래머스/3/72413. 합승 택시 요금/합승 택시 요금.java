import java.util.*;

class Solution {
    class Edge {
        int vertex;
        int weight;
        
        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
        public int getWeight() {
            return this.weight;
        }
        
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int INF = Integer.MAX_VALUE;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList());
        } 
        
        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];
            
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        
        int[] distFromS = dijkstra(s, graph, INF, n);
        int[] distFromA = dijkstra(a, graph, INF, n);
        int[] distFromB = dijkstra(b, graph, INF, n);
        int answer = INF;
        for (int i = 0; i <= n; i++) {
            answer = Math.min(answer, distFromA[i]+distFromB[i]+distFromS[i]);
        }
        return answer;
    }
    
    private int[] dijkstra(int start, List<List<Edge>> graph, int INF, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge:: getWeight));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        pq.offer(new Edge(start, 0));
        
        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.vertex;
            int currentDist = current.weight;
            
            if(currentDist < dist[currentNode]) {
                continue;
            }
            
            for (Edge neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.vertex;
                int weight = neighbor.weight;
                int distance = currentDist + weight;
                if(distance < dist[nextNode]) {
                    dist[nextNode] = distance;
                    pq.offer(new Edge(nextNode, distance));
                    
                }
            }
        }
        return dist;
    }
}