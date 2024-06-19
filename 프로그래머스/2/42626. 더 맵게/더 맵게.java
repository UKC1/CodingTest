import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int sco : scoville) {
            pq.offer(sco);
        }
        
        while(pq.size() > 1 && pq.peek() < K)  {
            int firstMin = pq.poll();
            int secondMin = pq.poll();
            pq.offer(firstMin + secondMin * 2);
            answer++;
        }
        
        if (pq.peek() < K) {
            return -1;
        }
        
        
        
        return answer;
    }
}