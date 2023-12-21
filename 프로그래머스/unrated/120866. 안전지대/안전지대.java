class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        boolean[][] visited = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 1) {
                    answer += bomb(board, visited, i, j) + 1;
                }
            }
        }
        
        return len * len - answer;
    }
    
    public int bomb(int[][] board, boolean[][] visited, int i, int j) {
        int cnt = 0;
        int[] xLine = {-1, 0, 1,};
        int[] yLine = {-1, 0, 1};
        
        int xi = 0;
        int yj = 0;
        for (int dx : xLine) {
            xi = i + dx;
            for (int dy : yLine) {
                yj = j + dy;
                
                if (xi < 0 || yj < 0 || xi > board.length - 1 || yj > board[0].length - 1) {
                    continue;
                }
                
                if (board[xi][yj] == 0 && !visited[xi][yj]) {
                    cnt++;
                    visited[xi][yj] = true;
                }
                    
            }
        }
        return cnt;
    }
    
}