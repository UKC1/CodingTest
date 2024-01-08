class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        for (int i = 0; i < dx.length; i++) {
            if(h + dx[i] < 0 || h + dx[i] >= board[0].length || w + dy[i] < 0 || w + dy[i] >= board.length) {
                continue;
            }
            if (board[h][w].equals(board[h + dx[i]][w + dy[i]])) {
                answer++;
            }
        }
        
        return answer;
    }
}