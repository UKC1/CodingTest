class Solution
{
    public int solution(String s) {
        int maxLen = 1;
        
        for (int center = 0; center < s.length(); center++) {
            maxLen = Math.max(maxLen, expand(s, center, center));       // 홀수 길이
            maxLen = Math.max(maxLen, expand(s, center, center + 1));   // 짝수 길이
        }
        
        return maxLen;
    }

    private int expand(String s, int left, int right) {
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }

}