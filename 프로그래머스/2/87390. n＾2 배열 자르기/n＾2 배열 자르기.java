class Solution {
    public long[] solution(int n, long left, long right) {
        long[] answer = new long[(int) (right - left + 1)];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = left / n > left % n ? left / n + 1: left % n + 1;
            left++;
        } 
        return answer;
    }
}