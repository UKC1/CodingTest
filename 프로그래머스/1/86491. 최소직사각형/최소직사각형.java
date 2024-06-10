class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] size : sizes) {
            int wid = Math.max(size[0], size[1]);
            int len = Math.min(size[0], size[1]);
            
            max = Math.max(max, wid);
            min = Math.max(min, len);
                
        }
        return max * min;
    }
}