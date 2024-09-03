import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                cnt++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }         
            queue.offer(cnt);
        }
        
        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }
        return answer;
    }
}