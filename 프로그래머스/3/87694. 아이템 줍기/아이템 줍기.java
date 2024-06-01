import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        boolean[][] visited = new boolean[102][102];
        boolean[][] isBoundary = new boolean[102][102];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    isBoundary[x][y] = true;
                }    
            }
        }
        
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2 + 1;
            int y1 = rec[1] * 2 + 1;
            int x2 = rec[2] * 2 - 1;
            int y2 = rec[3] * 2 - 1;
            
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    isBoundary[x][y] = false;
                }    
            }
        }
        
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] {characterX * 2, characterY * 2, 0});
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1], cnt = arr[2];
            
            if (x == itemX * 2 && y == itemY * 2) {
                return cnt / 2;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 102 && ny < 102 && isBoundary[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, cnt + 1});
                    
                }
            }
        }
        
        return answer;
    }
}