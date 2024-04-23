import java.util.*;
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[102][102];        
        boolean[][] isBoundary = new boolean[102][102];
        
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;

            for (int x = x1; x <= x2; x++) {
               for (int y = y1; y <= y2; y++) {
                   if (x == x1 || x == x2 || y == y1 || y == y2) {
                       isBoundary[x][y] = true;
                   }
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
       queue.offer(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;
       while (!queue.isEmpty()) {
           int[] arr = queue.poll();
           int x = arr[0];
           int y = arr[1];
           int cnt = arr[2];

           if (x == itemX * 2 && y == itemY * 2) {
               return cnt / 2;
           }

           for (int i = 0; i < 4; i++) {
               int nx = x + dx[i];
               int ny = y + dy[i];

               if (nx >= 0 && ny >= 0 && nx < 102 && ny < 102 && !visited[nx][ny] && isBoundary[nx][ny]) {
                   visited[nx][ny] = true;
                   queue.offer(new int[] {nx, ny, cnt + 1});
               }
           
           }
       }
        return -1;
        
    }
}