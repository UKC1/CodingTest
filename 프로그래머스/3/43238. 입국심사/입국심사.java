import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long low = 1;
        long high = (long)times[0] * n;
        long answer = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long peopleCnt = 0;
            for (int time : times) {
                peopleCnt += mid / time;
                if (peopleCnt >= n) break;
            }
            
            if (peopleCnt >= n) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}