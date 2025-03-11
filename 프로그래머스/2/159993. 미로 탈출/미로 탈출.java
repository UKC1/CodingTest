import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    public int solution(String[] maps) {
        int sx = 0;
        int sy = 0;
        int lx = 0;
        int ly = 0;
        int ex = 0;
        int ey = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lx = i;
                    ly = j;
                } else if (maps[i].charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        int sToL = bfs(maps, sx, sy, lx, ly);
        int lToE = bfs(maps, lx, ly, ex, ey);
    
        if (sToL == -1 || lToE == -1) {
            return -1;
        }
        
        return sToL + lToE;
    }
    
    public int bfs(String[] maps, int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {startX, startY, 0});
        int N = maps.length;
        int M = maps[0].length();
        boolean[][] visited = new boolean[N][M];
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];
            if (x == endX && y == endY) {
                return time;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, time + 1});
                }
            }
        }
        return -1;
    }
}