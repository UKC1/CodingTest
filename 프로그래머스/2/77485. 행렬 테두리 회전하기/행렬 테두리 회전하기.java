import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int cnt = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = cnt++;
            }
        }
        
        int[] answer = new int[queries.length];
        
        // 회전하기
        int idx = 0;
        for (int[] query : queries) {
            int startX = query[0] - 1;
            int startY = query[1] - 1;
            int endX = query[2] - 1;
            int endY = query[3] - 1;
            
            // startX, startY 기준으로 시계 방향 회전해야 함
            int dir = 0;
            int x = startX;
            int y = startY;
            int minNum = Integer.MAX_VALUE;
            int tmp = -1;
            while (dir < 4) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < startX || ny < startY || nx > endX || ny > endY) {
                    dir = dir + 1;
                    if (dir == 4) break; 
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }
                // 한 칸씩 땡겨
                if (tmp == -1) {
                    tmp = map[nx][ny];
                    map[nx][ny] = map[x][y];
                } else {
                    int next = map[nx][ny];
                    map[nx][ny] = tmp;
                    tmp = next;
                }
                minNum = Math.min(minNum, tmp);
                x = nx;
                y = ny;
            }
            answer[idx++] = minNum;
        }
        
        return answer;
    }
}