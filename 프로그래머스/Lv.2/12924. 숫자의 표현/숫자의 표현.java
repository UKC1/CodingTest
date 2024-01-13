class Solution {
    public int solution(int n) {
        int answer = 0;
        int idx = 1;
        while (idx < n) {
            int cnt = idx;
            int i = idx + 1;
            while (cnt < n) {
                cnt += i;
                i++;
            }
            if (cnt == n) {
                answer++;
            }
            idx++;
        }
        return answer + 1; 
    }
}