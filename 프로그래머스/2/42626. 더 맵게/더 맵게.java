import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scov : scoville) {
            pq.offer(scov);
        }
        
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + second * 2);
            answer++;
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}
