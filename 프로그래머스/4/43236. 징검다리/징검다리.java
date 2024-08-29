import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 1; // 최소 거리
        int right = distance; // 최대 거리
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int removeCount = 0;
            int prev = 0; // 시작점

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    // 바위를 제거
                    removeCount++;
                } else {
                    prev = rock; // 바위를 남겨둠
                }
            }
            
            // 마지막 남은 거리 처리
            if (distance - prev < mid) {
                removeCount++;
            }
            
            // 제거한 바위의 수가 n보다 많으면, 최소 거리를 줄임
            if (removeCount > n) {
                right = mid - 1;
            } else {
                // 제거한 바위의 수가 n 이하이면, 답을 갱신하고 최소 거리를 늘림
                answer = mid;
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
