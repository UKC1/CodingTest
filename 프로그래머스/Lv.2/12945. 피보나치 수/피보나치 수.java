class Solution {
    public int solution(int n) {
        int answer = 1;
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; i++) {
            a = b;
            b = answer;
            answer = (a + b) % 1234567;
        }
        return answer;
    }
}