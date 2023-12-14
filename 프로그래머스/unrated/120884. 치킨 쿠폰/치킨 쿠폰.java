class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int plus = 1;
        int remain = 1;
        
        while (plus > 0) {
            plus = chicken / 10;
            remain = chicken % 10;
            answer += plus;
            chicken = plus + remain;
        }
        
        return answer;
    }
}