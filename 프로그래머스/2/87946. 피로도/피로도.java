import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        return dfs(dungeons, new boolean[dungeons.length], k, 0);
    }
    
    // 최대 피로도 반환하는 DFS 구현
    public int dfs(int[][] dungeons, boolean[] visited, int remainFatigue, int maxDungeonCnt) {
        int maxCnt = maxDungeonCnt;
        if (remainFatigue <= 0) {
            return maxCnt;
        }
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && remainFatigue >= dungeons[i][0]) {
                visited[i] = true;
                maxCnt = Math.max(maxCnt, dfs(dungeons, visited, remainFatigue - dungeons[i][1], maxDungeonCnt + 1));
                visited[i] = false;
            }
        }
        return maxCnt;
    }
}