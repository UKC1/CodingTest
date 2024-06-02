class Solution {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, 0);
        return max;
    }
    
    public void dfs(int[][] dungeons, boolean[] visited, int k, int cnt) {
        max = Math.max(cnt, max);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(dungeons, visited, k - dungeons[i][1], cnt + 1);
                visited[i] = false;
            }
        }
    }
}