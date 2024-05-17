import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0] - 1).add(wire[1] - 1);
            graph.get(wire[1] - 1).add(wire[0] - 1);
        }
        
        for (int[] wire : wires) {
            int node1 = wire[0] - 1;
            int node2 = wire[1] - 1;
            
            graph.get(node1).remove(Integer.valueOf(node2));
            graph.get(node2).remove(Integer.valueOf(node1));
            
            int subNode1 = bfs(graph, node1, n);
            int subNode2 = n - subNode1;
            
            answer = Math.min(Math.abs(subNode1 - subNode2), answer);
            
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
    
        return answer;
    }
    
    public int bfs(List<List<Integer>> graph, int start, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        visited[start] = true;
        int count = 1;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    count++;
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }    
        }
        
        return count;
        
    }
}