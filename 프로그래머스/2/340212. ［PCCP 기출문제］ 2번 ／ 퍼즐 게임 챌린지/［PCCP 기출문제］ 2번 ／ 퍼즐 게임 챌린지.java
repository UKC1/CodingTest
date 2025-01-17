class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int answer = 1;
        int left = 1;
        int right = Integer.MAX_VALUE;
        while(left < right) {
            int level = left + (right - left) / 2;
            long time = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= level) {    
                    time += times[i];
                } else {
                    int diff = diffs[i] - level; 
                    int preTime = 0;
                    for (int j = i - 1; j <= i; j++) {
                        preTime += times[j];
                    }
                    time += diff * preTime + times[i];
                }
            }
            
            if (time > limit) {
                left = level + 1;
            } else {
                answer = level;
                right = level;
            }
        }
        return answer;
    }
}