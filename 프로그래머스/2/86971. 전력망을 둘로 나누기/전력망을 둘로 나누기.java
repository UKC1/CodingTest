import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 그래프를 인접 리스트로 구성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0] - 1).add(wire[1] - 1);
            graph.get(wire[1] - 1).add(wire[0] - 1);
        }
        
        // 각 전선을 제거하면서 탐색
        for (int[] wire : wires) {
            // 전선 제거
            int node1 = wire[0] - 1;
            int node2 = wire[1] - 1;
            graph.get(node1).remove((Integer) node2);
            graph.get(node2).remove((Integer) node1);
            
            // 두 트리의 노드 개수 계산
            int nodesInSubtree1 = bfs(graph, node1, n);
            int nodesInSubtree2 = n - nodesInSubtree1;
            
            // 두 트리의 노드 개수 차이 계산
            answer = Math.min(answer, Math.abs(nodesInSubtree1 - nodesInSubtree2));
            
            // 전선 복구
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        
        return answer;
    }
    
    // BFS를 사용하여 트리의 노드 개수를 계산
    private int bfs(List<List<Integer>> graph, int start, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        return count;
    }
}
