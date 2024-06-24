class Solution {
    int solution(int[][] land) {
        int rows = land.length;
        int[] prevMax = new int[4];
        
        // 첫 번째 행 초기화
        for (int i = 0; i < 4; i++) {
            prevMax[i] = land[0][i];
        }
        
        // 각 행을 순회하면서 그리디하게 최대 합을 갱신
        for (int i = 1; i < rows; i++) {
            int[] currMax = new int[4];
            for (int j = 0; j < 4; j++) {
                int maxVal = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        maxVal = Math.max(maxVal, prevMax[k]);
                    }
                }
                currMax[j] = land[i][j] + maxVal;
            }
            prevMax = currMax;
        }
        
        // 최댓값 반환
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = Math.max(result, prevMax[i]);
        }
        return result;
    }
}
