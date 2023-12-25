class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long numP = Long.parseLong(p);
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            if (numP >= Long.parseLong(t.substring(i, i + p.length()))) {
                answer++;
            }
        }
        return answer;
    }
}