class Solution {
    public String solution(String s) {
        String answer = s.length() % 2 != 0 ? s.charAt(s.length() / 2) + "" : s.charAt(s.length() / 2 - 1) + "" + s.charAt(s.length() / 2);
        
        return answer;
    }
}