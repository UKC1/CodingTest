import java.util.*;
class Solution {
    int[] dx = {1, 0, -1};
    int[] dy = {0, 1, -1};
    public int[] solution(int n) {
        int[][] answer = new int[n][];
        int size = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            answer[i] = new int[i + 1];
        }
        // 1. 방향 규칙
        // 하 - 우 - 상 
        // 2. 사이클 규칙 다 돌면 한 칸씩 안쪽으로 당겨짐
        // start, end가 1칸 씩!
        int cnt = 1;
        int[] result = new int[size];
        int x = 0;
        int y = 0;
        int dir = 0;
        while (cnt <= size) {
            answer[x][y] = cnt++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || nx >= n || ny < 0 || ny >= answer[nx].length || answer[nx][ny] != 0) {
                
                dir = (dir + 1) % 3;
                x = x + dx[dir];
                y = y + dy[dir];
                continue;
            } 
            x = nx;
            y = ny;
        }
        int idx = 0;
        for (int[] ans : answer) {
            for (Integer num : ans) {
                result[idx++] = num;
            }
        }
        return result;
    }
}