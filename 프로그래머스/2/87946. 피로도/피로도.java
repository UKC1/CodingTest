class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = dfs(k, 0, new boolean[dungeons.length], dungeons);
        return answer;
    }
    
    public int dfs(int k, int maxCount, boolean[] visited, int[][] dungeons) {
        int cnt = maxCount;
        for (int i = 0; i < visited.length; i++) {
            int needFatigue = dungeons[i][0];
            int consumeFatigue = dungeons[i][1];
            if (!visited[i] && k >= needFatigue) {
                visited[i] = true;
                cnt = Math.max(cnt, dfs(k - consumeFatigue, maxCount + 1, visited, dungeons));
                visited[i] = false;
            }
        }
        return cnt;
    }
}