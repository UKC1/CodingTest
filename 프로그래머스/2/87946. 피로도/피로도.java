class Solution {
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];     
        
        return dfs(k, dungeons, visited);
    }
    
    public int dfs(int k, int[][] dungeons, boolean[] visited) {
        int maxCount = 0;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                maxCount = Math.max(maxCount, 1 + dfs(k - dungeons[i][1], dungeons, visited));
                visited[i] = false;
            }
        }
        return maxCount;
    }
}