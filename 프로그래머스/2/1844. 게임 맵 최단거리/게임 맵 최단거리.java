import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int answer = bfs(maps, visited, 0, 0);
        return answer;
    }
    
    int bfs(int[][] maps, boolean[][] visited, int x, int y) {
        int n = maps.length, m = maps[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.offer(new int[] {x, y, 1});
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            x = current[0];
            y = current[1];
            int cnt = current[2];
            
            if (x == n - 1 && y == m - 1) {
                return cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, cnt + 1});
                }
            }
        }
        return -1;
    }
}