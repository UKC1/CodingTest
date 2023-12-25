class Solution {
    public long solution(int n) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }
        
        long num = Long.parseLong(sb.toString());
        int i = 0;
        while (num > 0) {
            answer += (num % 10) * (int) Math.pow(3, i++);
            num /= 10;
        }
        return answer;
    }
}