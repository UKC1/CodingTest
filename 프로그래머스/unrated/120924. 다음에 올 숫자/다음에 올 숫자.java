class Solution {
    public int solution(int[] common) {
        int d = common[1] - common[0];
        int r = 0;
        if (common[0] != 0) {
            r = common[1] / common[0];
        }
        int answer = 0;
        
        for (int i = 2; i < common.length; i++) {
            if (common[i] - common[i - 1] == d) {
                answer = common[common.length - 1] + d;
                break;
            } else {
                answer = common[common.length - 1] * r;
                break;
            }
        }
        
        return answer;
    
    }
}