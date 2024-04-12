import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList();
        
        queue.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1], dist = arr[2];
            if(x == n - 1 && y == m - 1) {
                return dist;
            }
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    queue.offer(new int[] {nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}