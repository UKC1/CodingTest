import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        for (int i = 0; i < schedules.length; i++) {
            schedules[i] += 10;
            if (schedules[i] % 100 >= 60) {
                schedules[i] += 40;
            }
        }
        
        int idx = 0;
        for (int[] timelog : timelogs) {
            int day = startday;
            for (int i = 0; i < timelog.length; i++) {
                if (day >= 6) {
                    day++;
                    if (day == 8) {
                        day = 1;
                    }
                    continue;
                }
                
                if (timelog[i] > schedules[idx]) {
                    answer--;
                    break;
                }
                
                day++;
            }
            idx++;
        }
        
        return answer;
    }
}