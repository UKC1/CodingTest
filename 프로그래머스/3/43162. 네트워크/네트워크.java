class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(computers, visited, i);        
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, boolean[] visited, int start) {
        visited[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[start][i] == 1) {
                dfs(computers, visited, i);
            }
        }
    }
}