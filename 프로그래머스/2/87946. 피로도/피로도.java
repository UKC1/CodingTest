import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        answer = Math.max(answer, dfs(k, dungeons, visited, 0));
        System.out.println(answer);
        return answer;
    }
    
    public int dfs(int k, int[][] dungeons, boolean[] visited, int cnt) {
        int maxCnt = cnt;
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                maxCnt = Math.max(maxCnt, dfs(k - dungeons[i][1], dungeons, visited, cnt + 1));
                visited[i] = false;
            }
        }
        return maxCnt;
    }
}