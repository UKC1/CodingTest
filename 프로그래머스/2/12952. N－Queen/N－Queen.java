class Solution {
    int cnt = 0;
    public int solution(int n) {
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n - 1];
        boolean[] d2 = new boolean[2 * n - 1];
        dfs(cols, d1, d2, 0);
        return cnt;
    }
    
    void dfs(boolean[] cols, boolean[] d1, boolean[] d2, int row) {
        if (row == cols.length) {
            cnt++;
            return;
        }
        
        for (int col = 0; col < cols.length; col++) {
            int diag1 = row + col;
            int diag2 = cols.length - 1 + row - col;
            if (!cols[col] && !d1[diag1] && !d2[diag2]) {
                cols[col] = d1[diag1] = d2[diag2] = true;
                dfs(cols, d1, d2, row + 1);
                cols[col] = d1[diag1] = d2[diag2] = false;
            }
        }
    }
}