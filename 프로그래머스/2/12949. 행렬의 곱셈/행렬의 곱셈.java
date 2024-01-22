class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++){
            int idx = 0;
            while(idx < arr2[0].length) {
                int sum = 0;
                for (int j = 0; j < arr1[0].length; j++) {
                    sum += arr1[i][j] * arr2[j][idx];
                }
                answer[i][idx++] = sum;
            }
        }         
        return answer;
    }
}