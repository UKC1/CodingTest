import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long low = 1;
        long high = (long) times[0] * n;
        long answer = high;

        while (low <= high) {
            long mid = (low + high) / 2;
            long peopleProcessed = 0;

            for (int time : times) {
		            // 해당 시간에 끝난 사람들의 수
                peopleProcessed += mid / time;
                if (peopleProcessed >= n) break;  // 이미 필요한 사람 수를 채웠으면 더 이상 계산할 필요 없음
            }

            if (peopleProcessed >= n) {
                answer = mid;  // 현재 mid 시간이 가능한 경우, 더 짧은 시간 시도
                high = mid - 1;
            } else {
                low = mid + 1;  // mid 시간이 부족한 경우, 더 긴 시간 시도
            }
        }

        return answer;
    }
}
