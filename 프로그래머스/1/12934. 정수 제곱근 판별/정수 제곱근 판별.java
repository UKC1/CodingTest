class Solution {
    public long solution(long n) {
        long answer = 0;
        for (long i = 0; i <= Math.sqrt(n); i++) {
            if (n == i * i) {
                return (i + 1) * (i + 1);
            } else {
                answer = -1;
            }
        }
        return answer;
    }
}