class Solution {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        for (int[] arr : sizes) {
            int subMax = Math.max(arr[0], arr[1]);
            int subMin = Math.min(arr[0], arr[1]);
            if (max < subMax) {
                max = subMax;
            }
            
            if (min < subMin) {
                min = subMin;
            }
        }
        return max * min;
    }
}