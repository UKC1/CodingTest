class Solution {
    public int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        } 
        int answer = lcm(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    
    public int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return gcd(m, n % m);
    }
    
    public int lcm(int n, int m) {
        return n * m / gcd(n, m) ;
    }
}