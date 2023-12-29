class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int idx = 0;
        int row = 0;
        int col = 0;
        int cnt = 1;
        
        boolean isRow = true;
        boolean isCol = true;
        
        while (cnt <= answer.length * answer.length) {
            if (isRow && isCol) {
                if (col < n - idx) {
                    answer[row][col++] = cnt++;
                } else {
                    col--;
                    row++;
                    isRow = !isRow;
                }
            } else if (isCol && !isRow) {
                if (row < n - idx) {
                    answer[row++][col] = cnt++;
                } else {
                    row--;
                    col--;
                    isCol = !isCol;
                    isRow = !isRow;
                }
            } else if (isRow && !isCol) {
                if (col > idx - 1) {
                    answer[row][col--] = cnt++;
                } else {
                    row--;
                    col++;
                    isRow = !isRow;
                    idx++;
                }
            } else if (!isCol && !isRow) {
                if (row > idx - 1) {
                    answer[row--][col] = cnt++;
                } else {
                    col++;
                    row++;
                    isCol = !isCol;
                    isRow = !isRow;
                } 
                
            }
        }
            
       
        return answer;
    }
}