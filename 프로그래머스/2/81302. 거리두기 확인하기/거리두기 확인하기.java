import java.util.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    char[][] map;
    public int[] solution(String[][] places) {
        // 거리를 둬서 대기를 해야 함
        // 대기실 5개 
        // 각 대기실 5 x 5
        // 맨해튼 거리 2이하 |x1 - x2| + |y1 - y2| x
        // 단 응시자가 앉아있는 사이가 파티션으로 막혀 있으면 ok
        // O : 빈테이블 P : 사람 X : 파티션
        int[] answer = new int[5];
        for (int i = 0; i < places.length; i++) {
            map = new char[5][5];
            for (int j = 0; j < places[i].length; j++) {
                map[j] = places[i][j].toCharArray();
            }
            
            
            boolean isTrue = true;
            loop : for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (map[row][col] == 'P') {
                        isTrue = check(row, col);
                        if (!isTrue) {
                            break loop;         
                        }
                    }
                }
            }
            
            if (isTrue) answer[i] = 1;
        }
        
        return answer;
    }
    
    boolean check(int row, int col) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col, 0});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            
            if (map[x][y] == 'P' && dist != 0 && dist <= 2) {
                return false;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, dist + 1});
                }
            }
        }
        
        return true;
    }
}