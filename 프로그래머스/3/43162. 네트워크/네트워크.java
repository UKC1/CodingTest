class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, int start, boolean[] visited) {
        visited[start] = true;
        for (int i = 0; i < visited.length; i++) {
            if (computers[i][start] == 1 && !visited[i]) {
                dfs(computers, i, visited);
            }
        }
    }
}