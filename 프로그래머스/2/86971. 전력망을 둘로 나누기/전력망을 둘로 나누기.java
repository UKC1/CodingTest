import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;
        int[][] graph = new int[n + 1][n + 1];
        
        // 그래프 초기화
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        
        // 간선을 하나씩 제거하며 최소 차이 계산
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            
            // 간선 제거
            graph[start][end] = 0;
            graph[end][start] = 0;
            
            // BFS를 사용하여 각 컴포넌트의 노드 개수를 계산
            int part1 = bfs(graph, start, n);
            int part2 = n - part1;
            minDiff = Math.min(minDiff, Math.abs(part1 - part2));
            
            // 간선 복구
            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        
        return minDiff;
    }
    
    private int bfs(int[][] graph, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    count++;
                }
            }
        }
        
        return count;
    }
}
