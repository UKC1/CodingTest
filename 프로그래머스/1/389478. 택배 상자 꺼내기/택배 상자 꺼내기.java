import java.util.*;

class Solution {
    int[] dy = {1, -1};
    public int solution(int n, int w, int num) {
        int row = n % w == 0 ? n / w : n / w + 1;
        int[][] maps = new int[row][w];
        int cnt = 1;
        int x = row - 1;
        int y = 0;
        int dir = 0;
        
        int numX = x;
        int numY = y;
        while (cnt <= n) {
            maps[x][y] = cnt++;
            int nx = x;
            int ny = y + dy[dir];
            
            if (ny == w || ny < 0) {
                nx = x - 1;
                ny = y;
                dir = (dir + 1) % 2;
            }
            x = nx;
            y = ny;
            
            if (cnt == num) {
                numX = x;
                numY = y;
            }
        }
        
        int answer = 0;
        for (int i = numX; i >= 0; i--) {
            if (maps[i][numY] != 0) {
                answer++;
            }
        }
        return answer;
    }
}