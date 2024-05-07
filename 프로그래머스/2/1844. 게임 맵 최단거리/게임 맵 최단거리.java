import java.util.*;

class Solution {
    public int solution(int[][] maps) {
      
        int n = maps.length, m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            
            if (arr[0] + 1 == n && arr[1] + 1 == m) {
                return arr[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, arr[2] + 1});
                }
            }
        }
        return -1;
    }
}