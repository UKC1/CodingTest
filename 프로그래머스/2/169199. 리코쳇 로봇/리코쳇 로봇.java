import java.util.*;
class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int N, M;
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        int startX = -1, startY = -1, endX = -1, endY = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                } else if (board[i].charAt(j) == 'G') {
                    endX = i;
                    endY = j;
                }
            }
        }
        int answer = bfs(startX, startY, endX, endY, board);
        return answer;
    }
    
    int bfs(int startX, int startY, int endX, int endY, String[] board) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {startX, startY, 0});
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int cnt = curr[2];
            if (x == endX && y == endY) {
                return cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx].charAt(ny) != 'D') {
                    // 장애물 혹은 경계까지 가야 됨
                    while (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx].charAt(ny) != 'D') {
                        nx += dx[i];
                        ny += dy[i];
                    }
                    nx -= dx[i];
                    ny -= dy[i];
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[] {nx, ny, cnt + 1});    
                    }
                }
                
                
            }
            
        }
        
        return -1;
    }
}