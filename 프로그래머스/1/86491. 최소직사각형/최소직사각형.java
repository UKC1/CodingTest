class Solution {
    public int solution(int[][] sizes) {
        int maxWid = 0;
        int maxLen = 0;
        for (int[] card : sizes) {
            int large = Math.max(card[0], card[1]);
            int small = Math.min(card[0], card[1]);
            maxWid = Math.max(large, maxWid);
            maxLen = Math.max(small, maxLen);
        }
        return maxWid * maxLen;
    }
}