class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = '1';
        char second = '2';
        char other = '0';
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (first == '1') {
                first = s.charAt(i);
                cnt++;
            } else if (first == s.charAt(i)) {
                cnt++;
            } else {
                if (second == '2') {
                    second = s.charAt(i);
                    cnt--;
                } else if (second == s.charAt(i)) {
                    cnt--;
                } else {
                    other = s.charAt(i);
                    cnt--;
                }
            }
            
            if (cnt == 0) {
                first = '1';
                second = '2';
                answer++;
            }
        }
        
        return cnt != 0 ? answer + 1 : answer;
    }
}