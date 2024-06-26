class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int rows = land.length;
        int[] prev = new int[4];
        int[] curr = new int[4];
        for (int i = 0; i < 4; i++) {
            prev[i] = land[0][i];
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < 4; j++) {
                curr[j] = land[i][j] + Math.max(prev[(j + 1) % 4], Math.max(prev[(j + 2) % 4], prev[(j + 3) % 4]));
            }
            
            for (int j = 0; j < 4; j++) {
                prev[j] = curr[j];
            }
        }
        
        return Math.max(prev[0], Math.max(prev[1], Math.max(prev[2], prev[3])));
    }
}