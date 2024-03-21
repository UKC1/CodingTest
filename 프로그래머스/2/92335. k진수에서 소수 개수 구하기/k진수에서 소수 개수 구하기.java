class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] str = Integer.toString(n, k).split("0");
        for (int i = 0; i < str.length; i++) {
            if (!str[i].isEmpty() && prime(Long.parseLong(str[i]))) {
                answer++;
            }
        }
        return answer; 
    }
    
    public boolean prime(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; 
            }
        }
        return n > 1;
    }
}