import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        queue.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] dirArr = queue.poll();
            int x = dirArr[0], y = dirArr[1], cnt = dirArr[2];
            
            if (x == n - 1 && y == m - 1) {
                return cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, cnt + 1});
                }
            }
        }
        
        return -1;
    }
}