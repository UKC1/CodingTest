class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        int[] answer = new int[2];
        for (int i = 2; i <= Math.sqrt(total); i++) {
            if (total % i == 0) {
                int wid = i;
                int len = total / i;
                if ((wid - 2) * (len - 2) == yellow) {
                    answer[0] = len;
                    answer[1] = wid;
                }
            }
            
        }
        return answer;
    }
}