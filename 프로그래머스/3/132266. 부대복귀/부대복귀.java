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
        
        int[] distFromD = bfs(n, destination, edges);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distFromD[sources[i]] == INF ? -1 : distFromD[sources[i]];
        }
        return answer;
    }
    
    private int[] bfs(int n, int start, List<List<Integer>> edges) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start, 0});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currCnt = curr[1];
            
            for (Integer nextX : edges.get(currX)) {
                if (dist[nextX] == -1) {
                    dist[nextX] = currCnt + 1;
                    queue.offer(new int[] {nextX, currCnt + 1});
                }
            }
        }
        return dist;
    }
}