import java.util.Arrays;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int removeStone = 0;
            int prev = 0;
            
            for (int rock : rocks) {
                if (rock - prev < mid) {
                    removeStone++;
                } else {
                    prev = rock;
                }
            }
            
            if (distance - prev < mid) {
                removeStone++;
            }
            
            if (removeStone <= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}