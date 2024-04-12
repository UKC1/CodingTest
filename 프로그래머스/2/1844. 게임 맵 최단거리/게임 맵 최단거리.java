import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length, m = maps[0].length;
        Queue<int[] > queue = new LinkedList();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] check = queue.poll();
            int x = check[0];
            int y = check[1];
            int dist = check[2];
            
            if (x == n - 1 && y == m - 1) {
                return dist;
            }
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, dist + 1});
                }
            }
        }
        return -1;
    }
}