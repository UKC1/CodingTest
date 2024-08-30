import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long)times[0] * n;
        long answer = right;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            long personCnt = 0;
            for (int time : times) {
                personCnt += mid / time;
                if (personCnt >= n) break;
            }
            
            if (personCnt >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}