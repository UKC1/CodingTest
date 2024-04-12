import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작 위치와 거리 초기화
        queue.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        // BFS 실행
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];
            
            // 목표 도착 시 거리 반환
            if (x == n - 1 && y == m - 1) {
                return dist;
            }
            
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, dist + 1});
                }
            }
        }
        
        // 목표 도착 불가 시
        return -1;
    }
}
