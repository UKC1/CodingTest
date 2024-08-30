import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        // Initialize the first element
        dp[0][0] = triangle[0][0];

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        // Find the maximum sum in the last row
        int answer = 0;
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[n-1][j]);
        }

        return answer;
    }
}
