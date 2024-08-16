import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            graph.get(start).add(end); 
            graph.get(end).add(start);
        }
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            remove(graph.get(start), end);
            remove(graph.get(end), start);
            // graph.get(start).remove(end);
            // graph.get(end).remove(start);
            minDiff = Math.min(minDiff, bfs(graph, start, end));
            graph.get(start).add(end); 
            graph.get(end).add(start);
        }
        return minDiff - 1;
    }
    void remove(List<Integer> list, int removeValue) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == removeValue) {
                list.remove(i);
                break;
            }
        }
    }
    
    int bfs(List<List<Integer>> graph, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        if (graph.get(start).size() > graph.get(end).size()) {
            queue.offer(end);
            visited[end] = true;
        } else {
            queue.offer(start);
            visited[start] = true;
        }
        int totalCnt = 0;
        while(!queue.isEmpty()) {
            int cnt = 1;
            int V = queue.poll();
            visited[V] = true;
            List<Integer> list = graph.get(V);
            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i)]) {
                    queue.offer(list.get(i));
                    cnt++;
                }
            }
            totalCnt += cnt;
        }
        return (int)Math.abs(graph.size() - 1 - totalCnt);
    }
}