class Solution {
    public boolean solution(int x) {
        int num = x;
        int sum = 0;
        
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        
        boolean answer = x % sum == 0 ? true : false;
        return answer;
    }
}