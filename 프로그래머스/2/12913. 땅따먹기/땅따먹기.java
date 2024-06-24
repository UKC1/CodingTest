class Solution {
    int solution(int[][] land) {
        int rows = land.length;
        int[][] dp = new int[rows][4];
        
        // 첫 번째 행 초기화
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        // DP 배열 채우기
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = land[i][j] + Math.max(dp[i-1][(j+1)%4], Math.max(dp[i-1][(j+2)%4], dp[i-1][(j+3)%4]));
            }
        }
        
        // 최댓값 반환
        return Math.max(dp[rows-1][0], Math.max(dp[rows-1][1], Math.max(dp[rows-1][2], dp[rows-1][3])));
    }
}
