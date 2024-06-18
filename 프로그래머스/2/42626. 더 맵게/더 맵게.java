import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();      
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        while(pq.size() >= 2 && pq.peek() < K) {
            
            int newScov = pq.poll() + pq.poll() * 2;
            pq.offer(newScov);
            answer++;
        }
        
        if (pq.size() < 2 && pq.peek() < K) {
            return -1;
        }
        return answer;
    }
}