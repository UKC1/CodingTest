class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxLong = 0;
        int maxShort = 0;
        for (int i = 0; i < sizes.length; i++) {
            maxLong = Math.max(maxLong, Math.max(sizes[i][0], sizes[i][1]));
            maxShort = Math.max(maxShort, Math.min(sizes[i][0], sizes[i][1]));
        }
        return maxLong * maxShort;
    }
}