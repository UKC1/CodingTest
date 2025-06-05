import java.util.*;
class Solution {
    final int INF = Integer.MAX_VALUE;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            edges.get(road[0]).add(road[1]);
            edges.get(road[1]).add(road[0]);
        }
        
        int[] distFromD = dijkstra(n, destination, edges);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distFromD[sources[i]] == INF ? -1 : distFromD[sources[i]];
        }
        return answer;
    }
    
    private int[] dijkstra(int n, int start, List<List<Integer>> edges) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        pq.offer(new int[] {start, 0});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int curVertex = curr[0];
            int curCnt = curr[1];
            
            if (dist[curVertex] < curCnt) continue;
            
            for (Integer nextVertex : edges.get(curVertex)) {
                int nextCnt = dist[curVertex] + 1;
                if (dist[nextVertex] > nextCnt) {
                    dist[nextVertex] = nextCnt;
                    pq.offer(new int[] {nextVertex, nextCnt});
                }
            }
        }
        return dist;
    }
}